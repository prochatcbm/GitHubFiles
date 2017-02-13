import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Administrator on 13.02.2017.
 */
public class Tag_6_Exception extends JFrame {
    private int Zahl;
    JTextField text = new JTextField();
    JDialog meinJDialog = new JDialog();
    JLabel lab = new JLabel();

    Tag_6_Exception() {
        super();
    }

    Tag_6_Exception(int zahl) {
        super();

        switch (zahl) {
            case 1:
                buildTestDialog_1();
                break;

            default:
                break;
        }


    }

    public void buildTestDialog_1() {
        meinJDialog.setTitle("INT test");
        meinJDialog.setLayout(new GridLayout(2, 1));
        meinJDialog.addWindowListener(new EndProg());
        meinJDialog.setSize(450, 300);
        meinJDialog.getContentPane().add(text);
        lab.setText("start");
        meinJDialog.getContentPane().add(lab);
        text.addKeyListener(new Feld1());
        meinJDialog.setVisible(true);
    }


    public void stringChangeCommaToDot() {
        StringBuffer strB=new StringBuffer(text.getText());
        int deziPos=strB.indexOf(",");
        System.out.println(deziPos+"---"+text);
        strB.setCharAt(deziPos,'.');
    }

    public static void main(String[] args) {
        new Tag_6_Exception(1);
    }

    class Feld1 extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                try {
                    int z = Integer.parseInt(text.getText());
                    lab.setText("" + (z * 2));
                } catch (NumberFormatException g) {
                    JOptionPane.showMessageDialog(text, "keine int-Zahl");
                    text.setText("");
                }
            }
        }
    }
}