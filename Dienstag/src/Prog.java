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
        System.out.println("Nach dem Fahren sind "+verbraucht+" Liter verbraucht und "+vw[0].getTANK()+" Liter übrig.");


        double verbraucht2=vw[2].fahren(20);
        System.out.println("Nach dem Fahren sind "+verbraucht2+" Liter verbraucht und "+vw[2].getTANK()+" Liter übrig.");

        vw[3].setFARBE("");
        System.out.println(vw[3].getFARBE());

        vw[2].tanken(22000);
        vw[1].setTANK(22);
        vw[1].tanken(12);

        System.out.println(vw[1].getPS());
        System.out.println(vw[1].getKW());





    Taxi taxa = new Taxi(22);
    System.out.println("Taxometer Stand: "+taxa.getTaxoemter());
    taxa.setPS(90);

}

    static void ZeigeFahrzeuge(Pkw pkw) {
        System.out.println("############ Neuer PKW START ##########");
        System.out.println("Tank: " + pkw.getTANK() + " - PS: " + pkw.getPS() + " - VMAX:" + pkw.getVMAX() + " - Farbe: " + pkw.getFARBE());
        System.out.println("############ Neuer PKW END   ##########");

    }


}
