/**
 * Created by Administrator on 08.02.2017.
 */
public class Tag3 {
    static int zaehler = 0;
    final static int WERT = 25;
    final String GRUNDFARBE;


    Tag3(String grundfarbe) {
        GRUNDFARBE = grundfarbe;
        zaehler++;
    }


    static void tuWas() {
        System.out.println("Klassenmethode");

    }

    void tuMehr() {
        System.out.println(WERT);
        System.out.println(GRUNDFARBE);

    }


    public static void main(String[] args) {
        String s1 = "Hallo";
        String s2 = "Hallo Welt";
        String s3 = s1.substring(0, 5);

        boolean b = s1.equals(s2);
        System.out.println(b);
        System.out.println(s3);



    /*
        Tag3 a;


        if (args.length>0) {
            a = new Tag3(args[0]);
        } else {
            a = new Tag3("nix vorhanden");

        }
        a.tuMehr();
*/
        //        tuWas();
        //      System.out.println(Tag3.zaehler);


    }
}