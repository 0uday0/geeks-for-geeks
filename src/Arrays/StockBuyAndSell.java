package Arrays;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] input = {1,5,3,1,2,8};
        System.out.println("My Profit is "+profits(input));

    }

    public static int profits(int[] stockPrices) {
        int profit = 0;
        int days = stockPrices.length;
       int buyingPrice = stockPrices[0];
       for (int i = 1; i < days ; i +=1 ) {
           if (stockPrices[i] < buyingPrice) {
               buyingPrice = stockPrices[i];
           } else {
               profit += stockPrices[i]-buyingPrice;
               buyingPrice = stockPrices[i];
           }
       }

        return profit;


    }

    public static  int efficientProfits(int[] stockPrices) {
        int profit = 0;
        for (int i = 1; i < stockPrices.length; i +=1 ) {
            if (stockPrices[i]>stockPrices[i-1]) {
                profit += (stockPrices[i] -stockPrices[i-1]);
            }
        }
        return profit;

    }

}
