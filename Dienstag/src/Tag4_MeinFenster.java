import javax.swing.*;
import java.awt.*;
public class Tag4_MeinFenster extends JFrame {

    Tag4_MeinFenster() {

        super("Mein Fenster Programm");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1, 2));
        this.setSize(450, 300);

        JLabel lbl = new JLabel("Label");
        JButton btn = new JButton("Button");
        JTextArea txa = new JTextArea("Textarea");

        this.getContentPane().add(lbl);

        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        sp.add(txa, JSplitPane.TOP);
        sp.add(btn, JSplitPane.BOTTOM);

        this.getContentPane().add(sp);
        this.setResizable(false);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Tag4_MeinFenster();
    }
}