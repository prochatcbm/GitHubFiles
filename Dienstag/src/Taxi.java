/**
 * Created by Administrator on 07.02.2017.
 */
public class Taxi extends Pkw {
    private int taxometer;


    Taxi() {
        super();
        this.taxometer = 0;


    }

    Taxi(int taxometer) {
        super();
        this.taxometer = taxometer;
        this.Max_PS = 20;
    }

    public int getTaxoemter() {
        return this.taxometer;
    }

    public void setTaxoemter(int km) {
        this.taxometer = km;

    }

}
