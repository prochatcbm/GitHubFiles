public class Prog {

    public static void main(String[] args) {
        Fahrzeug audi = new Fahrzeug(80, 95, 240, "blau");
        Fahrzeug ente = new Fahrzeug();

        Pkw[] vw = new Pkw[5];

        /* FARBLISTE START*/
        String[] farbListe = new String[5];
        farbListe[0] = new String("rot");
        farbListe[1] = new String("weiß");
        farbListe[2] = new String("orange");
        farbListe[3] = new String("gelb");
        farbListe[4] = new String("rosa");
        /* FARBLISTE END*/

        /* PS LISTE START*/
        int[] psListe = {50, 60, 80, 120, 140};
        /* PS LISTE START*/


        for (int i = 0; i < vw.length; i++) {
            vw[i] = new Pkw(50, psListe[i], 40, farbListe[i]);
            ZeigeFahrzeuge(vw[i]);
        }

        double verbraucht=vw[0].fahren(120);
        System.out.println("Nach dem Fahren sind "+verbraucht+" Liter verbraucht und "+vw[0].tank+" Liter übrig.");


        double verbraucht2=vw[2].fahren(20);
        System.out.println("Nach dem Fahren sind "+verbraucht2+" Liter verbraucht und "+vw[2].tank+" Liter übrig.");

        vw[3].setFARBE("");
        System.out.println(vw[3].getFARBE());
        vw[3].setTANK(9999);




    }


    static void ZeigeFahrzeuge(Pkw _pkw) {
        System.out.println("############ Neuer PKW START ##########");
        System.out.println("Tank: " + _pkw.tank + " - PS: " + _pkw.ps + " - VMAX:" + _pkw.vmax + " - Farbe: " + _pkw.farbe);
        System.out.println("############ Neuer PKW END   ##########");

    }


}
