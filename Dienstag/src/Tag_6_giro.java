/**
 * Created by Administrator on 13.02.2017.
 */
public class Tag_6_giro extends Tag_6 {
    private double guthaben;
    private double zinssatz;

    Tag_6_giro() {
        super();
    }

    Tag_6_giro(double guthaben, double zinssatz) {
        super(guthaben);
        // ToDo Calc - keine Dauer?
    }



    public void setGiro(double money, double zinssatz) {
        this.guthaben=(money*zinssatz);
        // ToDo Keine Dauer ?


    }

    public double getGiro(double money, double zinssatz) {
        // ToDo Berechnen

        return this.guthaben;
    }

/*
    public static void main(String[] args) {

    }*/


}
