 /**
 * Created by Administrator on 10.02.2017.
 */

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Tag5 extends JFrame {
    JTextField tfield = new JTextField();
    JMenu menu = new JMenu("Ich bin ein JMenu");
    JDialog meinJDialog = new JDialog();

    Tag5() {
        super("Titel");
        meinJDialog.addWindowListener(new EndProg());
        meinJDialog.setTitle("Mein Fenster");
        meinJDialog.setSize(450, 300);
        Border bo = new LineBorder(Color.yellow);
        JMenuBar bar = new JMenuBar();
        bar.setBorder(bo);
        JMenuItem mnItemRot = new JMenuItem("rot");
        mnItemRot.setMnemonic(KeyEvent.VK_R);
        mnItemRot.addActionListener(new MenuListener());
        menu.add(mnItemRot);
        JMenuItem mnItemBlau = new JMenuItem("blau");
        mnItemBlau.setMnemonic(KeyEvent.VK_B);
        mnItemBlau.addActionListener(new MenuListener());
        menu.add(mnItemBlau);
        JMenuItem mnItemEnd = new JMenuItem("beenden");
        mnItemEnd.setMnemonic(KeyEvent.VK_Q);
        mnItemEnd.addActionListener(new MenuListener());
        menu.add(mnItemEnd);
        menu.setMnemonic(KeyEvent.VK_M);
        tfield.addActionListener(new TextListener());
        bar.add(menu);
        meinJDialog.setJMenuBar(bar);
        tfield.setText("text");
        meinJDialog.add(tfield);
        meinJDialog.setVisible(true);
    }

    public static void main(String[] args) {
        new Tag5();
    }

    class TextListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String Str_tmp = e.getActionCommand();
            meinJDialog.setTitle(Str_tmp);

        }

    }

    class MenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Selected: " + e.getActionCommand());

            switch (e.getActionCommand()) {
                case "rot":
                    tfield.setBackground(Color.red);

                    break;
                case "blau":
                    tfield.setBackground(Color.blue);

                    break;
                case "beenden":
                    System.exit(0);
                    break;

                default:
                    break;

            }


        }
    }
}

class EndProg extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}