import java.awt.*;
import java.awt.event.*;

/**
 * Created by Administrator on 08.02.2017.
 */
public class Tag3_java_awt {
    static Frame frm;

    Tag3_java_awt() {
        Build_Frame(2, 1, 300, 300);
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
        frm.add(btn);
    }

    void Build_Labels(String lbl_Text) {
        Label lbl = new Label(lbl_Text);
        frm.add(lbl);
    }

}


class ProgEnde extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

