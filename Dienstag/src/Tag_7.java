import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Administrator on 14.02.2017.
 */
public class Tag_7 extends JFrame {
    private JFileChooser dateiAuswahl;
    private File DateiName;
    private JTextField txt;
    private JTextArea txtA;
    JMenu menu = new JMenu("Ich bin ein JMenu");
    JDialog meinJDialog = new JDialog();


    Tag_7() {
        super();
        BuildApp();
    }

    public void BuildApp() {
        int width = 450;
        int height = 300;
        String[] MenueItems = {"Verzeichnis", "JTextArea speichern", "JTextArea öffnen", "Textzeile speichern", "Textzeile öffnen", "beenden"};
        meinJDialog.addWindowListener(new EndProg());
        meinJDialog.setTitle("Mein Fenster");
        meinJDialog.setSize(width, height);
        JMenuBar bar = new JMenuBar();
        for (int i = 0; i < MenueItems.length; i++) {
            JMenuItem Item = new JMenuItem(MenueItems[i]);
            Item.addActionListener(new MenuListener());
            menu.add(Item);
        }
        bar.add(menu);
        meinJDialog.setJMenuBar(bar);
        txt = new JTextField("Textfeld");
        meinJDialog.getContentPane().add(txt);
        txtA = new JTextArea("Text");
        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        sp.add(txt, JSplitPane.TOP);
        JScrollPane jts = new JScrollPane(txtA);
        jts.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.add(jts, JSplitPane.BOTTOM);
        meinJDialog.getContentPane().add(sp);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int moniBreite = dim.width;
        int moniHoehe = dim.height;
        meinJDialog.setLocation(((moniBreite / 2) - (width / 2)), ((moniHoehe / 2) - (height / 2)));
        meinJDialog.setVisible(true);
    }

    void ordnerLesen() {
        File ordner = new File(txt.getText());

        if (!ordner.exists()) {
            File ordnerStd = new File(".");
            String[] dateiListe = ordnerStd.list();
            txtA.setText("Dateipfad ungültig - Standard Verzeichnis \".\" wurder verwendet\n\n");
            for (int i = 0; i < dateiListe.length; i++) {
                txtA.append(dateiListe[i] + "\n");
            }
        } else {
            String[] dateiListe = ordner.list();
            txtA.setText("");
            for (int i = 0; i < dateiListe.length; i++) {
                txtA.append(dateiListe[i] + "\n");
            }
        }


    }


    void log(String txt) {
        System.out.println(txt);

    }

    void dateiSchreiben() {
        dateiAuswahl = new JFileChooser(".");
        DateiName = new File(".");
        int rueck = dateiAuswahl.showSaveDialog(meinJDialog);
        DateiName = dateiAuswahl.getSelectedFile();


        if ((rueck == JFileChooser.APPROVE_OPTION) && (DateiName != null)) {
            try {
                FileOutputStream fos = new FileOutputStream(DateiName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(txtA.getText());
                oos.flush();
                fos.close();
            } catch (FileNotFoundException e) { // catch für FileOutputStream
                e.printStackTrace();
            } catch (IOException e) { // catch für ObjectOutputStream
                e.printStackTrace();
            }
        }
    }

    void dateiLesen() {
        dateiAuswahl = new JFileChooser(".");
        DateiName = new File(".");
        int rueck = dateiAuswahl.showOpenDialog(meinJDialog);
        DateiName = dateiAuswahl.getSelectedFile();

        FileInputStream fis = null;

        if ((rueck == JFileChooser.APPROVE_OPTION) && (DateiName != null)) {

            try {
                fis = new FileInputStream(DateiName);
                ObjectInputStream ois = new ObjectInputStream(fis);

                txtA.setText((String)ois.readObject());


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    void schreibeTextZeile() {

    }

    void leseTextZeile() {

    }

    class MenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //  System.out.println("Selected: " + e.getActionCommand());

            //  dateiAuswahl
            //         DateiName

            switch (e.getActionCommand()) {
                case "Verzeichnis":
                    ordnerLesen();
                    break;
                case "JTextArea speichern":
                    dateiSchreiben();
                    break;
                case "JTextArea öffnen":
                    dateiLesen();
                    break;

                case "Textzeile speichern":
                    schreibeTextZeile();
                    break;
                case "Textzeile öffnen":
                    leseTextZeile();
                    break;

                case "beenden":
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }


    public static void main(String[] args) {
        Tag_7 TestApp = new Tag_7();
    }

}
