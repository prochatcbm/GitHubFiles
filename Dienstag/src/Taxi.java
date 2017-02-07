/**
 * Created by Administrator on 07.02.2017.
 */
public class Taxi extends Pkw{
    private int taxoemter;


    Taxi(){
        super();
        this.taxoemter=0;
    }

    Taxi(int taxometer){
        super();
        this.taxoemter=taxometer;
        this.Max_PS=20;
    }

    public int getTaxoemter() {
        return this.taxoemter;
    }

    public void setTaxoemter(int km) {
            this.taxoemter = km;
    }

}
