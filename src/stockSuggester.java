public class stockSuggester {
    stock [] stockArray;
    public stockSuggester(stock [] stockArray){
        this.stockArray=stockArray;
    }


// We will expand on the algorithm later. For now it is a mock algorithm projected Value;
    public String suggestStock() {
        double old_max = 0;
        double value;
        String name = "";

        for(int i =0;i<stockArray.length;i++){
            stockArray[i].financials.put("Projected Value",i+1.0);

        }


        for (int i = 0; i < this.stockArray.length; i++) {
            value = stockArray[i].financials.get("Projected Value");
            if (value > old_max) {
                old_max = value;
                name = stockArray[i].getStockName();

            }
            }
        return name;

    }




}
