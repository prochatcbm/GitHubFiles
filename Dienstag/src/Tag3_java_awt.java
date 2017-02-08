import java.awt.*;
import java.awt.event.*;

/**
 * Created by Administrator on 08.02.2017.
 */
public class Tag3_java_awt {
    Frame frm;
    Label lbl1;
    int cnter;

    Tag3_java_awt() {
        Build_Frame(3, 3, 300, 300);
        Build_Buttons("OK");
        Build_Labels("Label1");
    }

    public static void main(String[] args) {
        new Tag3_java_awt();
    }

    void Build_Frame(int rows, int cols, int width, int height) {
        frm = new Frame();
        frm.setSize(width, height);
        frm.setLayout(new GridLayout(rows, cols));
        frm.addWindowListener(new ProgEnde());
        frm.setVisible(true);

    }

    void Build_Buttons(String btnText) {
        Button btn = new Button(btnText);
        btn.addActionListener(new MeineAktion());
        frm.add(btn);
    }

    void Build_Labels(String lbl_Text) {
        lbl1 = new Label(lbl_Text);
        frm.add(lbl1);
    }

    void setTest() {
        Label lbl = new Label("Hannes");
        frm.add(lbl);

    }


    class MeineAktion implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            if (s.equals("OK")) {
                lbl1.setText(++cnter+" mal geklickt");
            }
        }
    }
}

class ProgEnde extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

