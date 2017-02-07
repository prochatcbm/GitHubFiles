/**
 * Created by Administrator on 07.02.2017.
 */
class Fahrzeug {
    int ps;
    int vmax;
    int tank;
    String farbe;

    Fahrzeug() {
        tank = 80;
        farbe = "schwarz";
        ps = 120;
        vmax = 220;
    }

    Fahrzeug(int _tank, int _ps, int _vmax, String _farbe) {
        tank = _tank;
        farbe = _farbe;
        ps = _ps;
        vmax = _vmax;
    }

    double fahren(int km){
        double verbr=(double) km * 0.09;
        tank-=(int)verbr;
        return verbr;
    }

}
