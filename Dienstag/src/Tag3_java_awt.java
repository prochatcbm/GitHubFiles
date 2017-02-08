import java.awt.*;
import java.awt.event.*;

/**
 * Created by Administrator on 08.02.2017.
 */
public class Tag3_java_awt {
    Frame frm;
    Label[] lbl;
    Button[] btn;
    int cnter;
    int btn_cnter = 0;
    int lbl_cnter = 0;

    Tag3_java_awt() {
        lbl = new Label[4];
        btn = new Button[2];
        int width = 300;
        int height = 300;
        Build_Frame(2, 3, width, height);
        Build_Labels("Label1");
        Build_Labels("Label2");
        Build_Labels("Label3");
        Build_Labels("Label4");
        Build_Buttons("OK");
        Build_Buttons("RESET");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int moniBreite = dim.width;
        int moniHoehe = dim.height;
        frm.setLocation(((moniBreite / 2) - (width / 2)), ((moniHoehe / 2) - (height / 2)));
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        new Tag3_java_awt();
    }

    void Build_Frame(int rows, int cols, int width, int height) {
        frm = new Frame();
        frm.setSize(width, height);
        frm.setLayout(new GridLayout(rows, cols));
        frm.addWindowListener(new ProgEnde());
    }

    void Build_Buttons(String btnText) {
        btn[btn_cnter] = new Button(btnText);
        btn[btn_cnter].setForeground(Color.getHSBColor(getRandomColor(), getRandomColor(), getRandomColor()));
        btn[btn_cnter].setBackground(Color.getHSBColor(getRandomColor(), getRandomColor(), getRandomColor()));
        frm.add(btn[btn_cnter]);
        btn[btn_cnter].addActionListener(new MeineAktion());
        btn_cnter++;
    }


    int getRandomColor() {
        int rand = (int) (Math.random() * 256);
        return rand;
    }


    void Build_Labels(String lbl_Text) {
        Font Standard = new Font("Serif", Font.BOLD, 14);
        lbl[lbl_cnter] = new Label(lbl_Text);
        lbl[lbl_cnter].setFont(Standard);
        frm.add(lbl[lbl_cnter]);
        lbl_cnter++;
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
                lbl[0].setText(++cnter + " mal geklickt");
                Pkw p = new Pkw(70, 130, 40, "rot");
                lbl[1].setText("Farbe:" + p.getFARBE());
                lbl[2].setText("PS:" + Integer.toString(p.getPS()));
                lbl[3].setText("TANK:" + Integer.toString(p.getTANK()));
            }
            if (s.equals("RESET")) {
                for (int i = 0; i <4 ; i++) {

                    lbl[i].setText("Label"+(i+1));
                }


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

