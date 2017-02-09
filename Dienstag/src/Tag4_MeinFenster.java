import com.example.databse.dbconnect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Administrator on 09.02.2017.
 */
public class Tag4_MeinFenster extends JFrame {


    Tag4_MeinFenster() {
        super("Mein Fenster Programm");

        dbconnect db = new dbconnect();
       // db.createDB();
        String test= db.getNamenFromDB();



        System.out.println("Name aus der Datenbank: "+test);


       // db.closeConnection();

/*
        int width = 300;
        int height = 300;
        this.setLayout(new GridLayout(1, 2));
        this.getContentPane().add(labels());
        this.getContentPane().add(SplitPane());
        this.setSize(width, height);
        this.addWindowListener(new ProgEnds());
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int moniBreite = dim.width;
        int moniHoehe = dim.height;
        this.setLocation(((moniBreite / 2) - (width / 2)), ((moniHoehe / 2) - (height / 2)));
        this.setVisible(true);

*/

    }


    JSplitPane SplitPane() {
        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        sp.add(Textarea("TEXT", 1, 1), JSplitPane.TOP);
        sp.add(TextScrollarea("", 1, 1), JSplitPane.BOTTOM);
        return sp;
    }

    JTextArea Textarea(String text, int rows, int cols) {
        JTextArea jt = new JTextArea(text, rows, cols);
        //jt.append(GenText(2, 63, 1040));
        // jt.append("Hallo");
        return jt;
    }

    private String GenText(int amount, int range, int start) {
        String ttext = "";

        for (int i = 0; i <= amount; i++) {
            int output = (int) (Math.random() * range + start);
            ttext += Character.toString((char) (output)) + "\n";
        }
        return ttext;
    }

    JScrollPane TextScrollarea(String text, int rows, int cols) {
        JScrollPane jts = new JScrollPane(Textarea(GenText(122, 63, 1040), 1, 1));
        // jts.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jts.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return jts;
    }


    JPanel labels() {
        JPanel p = new JPanel(new GridLayout(2, 1));
        JLabel[] l = new JLabel[2];
        for (int i = 0; i < l.length; i++) {
            l[i] = new JLabel("lab" + (i + 1));
            p.add(l[i]);
        }
        p.setBorder(BorderFactory.createTitledBorder("Mein Titel"));
        return p;
    }


    public static void main(String[] args) {
        new Tag4_MeinFenster();
    }
}

class ProgEnds extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}


