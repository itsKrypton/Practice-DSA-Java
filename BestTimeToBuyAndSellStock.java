// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int maxSellPrice = 0;

        for(int i = 1; i < prices.length; i++)
        {
            int currentSellPrice = prices[i] - buyPrice;
            maxSellPrice = Math.max(maxSellPrice, currentSellPrice);
            buyPrice = Math.min(buyPrice, prices[i]);
        }

        return maxSellPrice;
    }
}
