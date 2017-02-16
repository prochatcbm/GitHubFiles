import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 16.02.2017.
 */
public class Tag_9 extends JFrame {

    Tag_9(){

        JFrame jf = new JFrame();
        jf.setSize(200,200);

        //entweder
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //oder
        jf.addWindowListener(new ProgEnde());
        jf.setLayout(new GridLayout(2,3));
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new Tag_9();
    }



}
