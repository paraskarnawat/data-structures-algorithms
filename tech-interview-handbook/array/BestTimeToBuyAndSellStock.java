package array;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0, j = 0;
        int temp;
        for (int i = 1; i < prices.length; i++) {
            // calculate the current profit
            temp = prices[i] - prices[j];
            if (temp > profit) {
                profit = temp;
            }
            // if previous min is greater than current element, update minimum
            if (prices[i] < prices[j]) {
                j = i;
            }
        }
        return profit;
    }
}
