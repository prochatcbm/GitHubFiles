/**
 * Created by Administrator on 07.02.2017.
 */
public class Prog_2_b {
    static int zaehler = 6;
    final static int WERT = 12; //
    final String GRUNDFWARBE; // Wert im KONSTRUKTOR - könnte eine User Eingabe sein

    Prog_2_b() {  // KONSTRUKTOR
        Prog_2_b.zaehler++;
        GRUNDFWARBE = "gelb"; // VOR den ERSTEN ZUGRIFF mit einem Wert im Konstruktor belegt
    }


    Prog_2_b(String farbe) {
        this.GRUNDFWARBE = farbe;
    }

    public static void main(String[] args) {
//        new Prog_2_b();    // Erzeugt auch immer ein Objekt mit zaehler,wert und Farbe

        Prog_2_b N;

        if (args.length > 0) {
            N = new Prog_2_b(args[0]);
        } else {
            N = new Prog_2_b();
        }


        //Prog_2_b N = new Prog_2_b(); // Notwendig für Folgezeile
        //N.tuMehr();

        System.out.println("" + Prog_2_b.zaehler + " " + Prog_2_b.WERT + " " + N.GRUNDFWARBE);
        //  Prog_2_b.tuWas();

        //Prog_2_b H = new Prog_2_b("rot");
        //System.out.println(H.GRUNDFWARBE);


    }

    static void tuWas() {
        System.out.println("Klassenmethode");
    }

    void tuMehr() {
        System.out.println("Objektmethode");
    }
}