/**
 * Created by Administrator on 07.02.2017.
 */
class Fahrzeug {
    int ps;
    int vmax;
    int tank;
    String farbe;

    /* GRENZWERTE SETZEN */
    final int Max_PS = 400;
    final int Max_VMAX = 400;
    final int Max_TANK = 400;
    /* GRENZWERTE SETZEN */


    public int getPS() {
        return this.ps;
    }

    public void setPS(int _ps) {
        if (_ps > Max_PS) {
            ErrorString("Das Sind zuviele PS");
        } else {
            this.ps = _ps;
        }
    }

    public int getVMAX() {
        return this.vmax;
    }

    public void setVMAX(int _vmax) {
        if (_vmax > Max_VMAX) {
            ErrorString("Das Sind zuviele KMH");
        } else {
            this.vmax = _vmax;
        }
    }

    public int getTANK() {
        return this.tank;
    }

    public void setTANK(int _tank) {
        if (_tank > Max_TANK) {
            ErrorString("Das Sind zuviele Liter Benzin");
        } else {
            this.tank = _tank;
        }

    }

    public String getFARBE() {
        return this.farbe;
    }

    public void setFARBE(String _farbe) {
        if (_farbe == "" || _farbe==null) {
            ErrorString("Das ist keine Farbe");
        } else {
            this.farbe = _farbe;
        }

    }

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

    double fahren(int km) {
        double verbr = (double) km * 0.09;
        tank -= (int) verbr;
        return verbr;
    }

    private void ErrorString(String _error) {
        System.out.println(_error);
    }

}
