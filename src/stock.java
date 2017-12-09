import java.util.Map;
import java.util.HashMap;
public class stock {



    String name;
    HashMap<String,Double> financials;

    public stock(String name){
       this.name = name;
       financials = new  HashMap<String,Double>();
       makeRequest();


    }

    public Map<String,Double> print_stock_data(){
        return this.financials;
    }

    public String getStockName(){
        return this.name;

    }
   // API to make requests to yahoo finance API. Stock data Hard coded for now.
    public void  makeRequest(){
        this.financials.put("Value",23.1);
        this.financials.put("WeeklyHigh",33.1);
        this.financials.put("WeeklyLow",23.1);
        this.financials.put("Shares",23334.0);
    }


}
