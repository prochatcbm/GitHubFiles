/**
 * Created by Administrator on 07.02.2017.



 */
class Fahrzeug {
    private int ps;
    private int vmax;

    //ToDo Als Getter / Setter umbauen
    protected int tank;

    private String farbe;

    /* GRENZWERTE SETZEN */
    protected int Max_PS;
    protected int Max_VMAX = 400;
    protected int Max_TANK = 400;
    /* GRENZWERTE SETZEN */


    /* GETTER UND SETTER SETZEN */


    public void setPS(int ps) {
        if (ps > Max_PS) {
            ErrorString("Das Sind zuviele PS");
        } else {
            this.ps = ps;
        }
    }

    public int getVMAX() {
        return this.vmax;
    }

    public void setVMAX(int vmax) {
        if (vmax > Max_VMAX) {
            ErrorString("Das Sind zuviele KMH");
        } else {
            this.vmax = vmax;
        }
    }

    public int getTANK() {
        return this.tank;
    }

    public void setTANK(int tank) {
        if (tank > Max_TANK) {
            ErrorString("Das Sind zuviele Liter Benzin");
        } else {
            this.tank = tank;
        }

    }

    public String getFARBE() {
        return this.farbe;
    }

    public void setFARBE(String farbe) {
        if (farbe == "" || farbe == null) {
            ErrorString("Das ist keine Farbe");
        } else {
            this.farbe = farbe;
        }

    }


    public double getKW() {
        return this.ps * 0.7355;
    }

 /* GETTER UND SETTER SETZEN */

    Fahrzeug() {
        tank = 80;
        farbe = "schwarz";
        ps = 120;
        vmax = 220;
    }

    Fahrzeug(int tank, int ps, int vmax, String farbe) {
        this.tank = tank;
        this.farbe = farbe;
        this.ps = ps;
        this.vmax = vmax;
    }

    double fahren(int km) {
        double verbr = (double) km * 0.09;
        tank -= (int) verbr;
        return verbr;
    }


    void tanken(int liter) {
        if (Max_TANK < (this.tank + liter)) {
            ErrorString("So viel passt nich in den Tank");

        } else {
            this.tank += liter;
            System.out.println("Der Tank hat nun " + this.tank + " Liter Benin");
        }


    }

    public int getPS() {
        return this.ps;

    }


    private void ErrorString(String _error) {
        System.out.println(_error);
    }


}
