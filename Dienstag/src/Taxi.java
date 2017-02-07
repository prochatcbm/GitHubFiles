/**
 * Created by Administrator on 07.02.2017.
 */
public class Taxi extends Pkw{
    int taxoemter;


    Taxi(){
        super();
        taxoemter=0;
    }

    Taxi(int taxometer){
        super();
        this.taxoemter=taxometer;
    }

    public int getTaxoemter() {
        return this.taxoemter;
    }

    public void setTaxoemter(int km) {
            this.taxoemter = km;
    }

}
