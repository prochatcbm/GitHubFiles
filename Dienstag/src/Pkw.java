/**
 * Created by Administrator on 07.02.2017.
 */
public class Pkw extends Fahrzeug {

    final int SERIENNUMMER;
    static int anzahlPkw = 0;
    int anzahlTueren;

    Pkw() {
        super();
        SERIENNUMMER = 0;
    }


    Pkw(int tank, int ps, int vmax, String farbe) {

        super(tank, ps, vmax, farbe);
        anzahlPkw++;
        SERIENNUMMER = anzahlPkw;
    }

    Pkw(int tank, int ps, int vmax, String farbe,int anzahlTueren) {
        super(tank, ps, vmax, farbe);
        this.anzahlTueren=anzahlTueren;
        anzahlPkw++;
        SERIENNUMMER = anzahlPkw;
    }


    @Override
     double fahren(int km) {
        double verbr = (double) km * 0.07;
        this.tank -= (int) verbr;
        return verbr;
    }

    double fahren(int km, int fahrerNr) {
        double verbrauch;
        switch (fahrerNr) {
            case 1:
                verbrauch = 0.06;
                break;
            case 2:
                verbrauch = 0.07;
                break;

            case 3:
                verbrauch = 0.08;
                break;

            case 4:
                verbrauch = 0.09;
                break;

            case 5:
                verbrauch = 0.10;
                break;

            default:
                verbrauch = 0.12;
        }
        double verbr = (double) km * verbrauch;
        this.tank -= (int) verbr;
        return verbr;
    }




}
