// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

//import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {
    // Memoization
    /* public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return find(0, prices, 1, dp);
    }

    public static int find(int n, int[] prices, int canBuy, int[][] dp)
    {
        if(n == prices.length)
        return 0;

        if(dp[n][canBuy] != -1)
        return dp[n][canBuy];

        if(canBuy == 1)
        {
            int buy = -prices[n] + find(n + 1, prices, 0, dp);
            int dontBuy = find(n + 1, prices, 1, dp);

            return dp[n][canBuy] = Math.max(buy, dontBuy);
        }

        else
        {
            int sell = prices[n] + find(n + 1, prices, 1, dp);
            int dontSell = find(n + 1, prices, 0, dp);

            return dp[n][canBuy] = Math.max(sell, dontSell);
        }
    } */

    // Tabulation
    /* public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length + 1][2];

        for(int i = prices.length - 1; i >= 0; i--)
        {
            for(int j = 1; j >= 0; j--)
            {
                if(j == 1)
                {
                    int buy = -prices[i] + dp[i + 1][0];
                    int dontBuy = dp[i + 1][1];
        
                    dp[i][j] = Math.max(buy, dontBuy);
                }
        
                else
                {
                    int sell = prices[i] + dp[i + 1][1];
                    int dontSell = dp[i + 1][0];
        
                    dp[i][j] = Math.max(sell, dontSell);
                } 
            }
        }

        return dp[0][1];
    } */

    //Space Optimization
    public int maxProfit(int[] prices) {
        int next[] = new int[2];

        for(int i = prices.length - 1; i >= 0; i--)
        {
            int temp[] = new int[2];
            for(int j = 1; j >= 0; j--)
            {
                if(j == 1)
                {
                    int buy = -prices[i] + next[0];
                    int dontBuy = next[1];
        
                    temp[j] = Math.max(buy, dontBuy);
                }
        
                else
                {
                    int sell = prices[i] + next[1];
                    int dontSell = next[0];
        
                    temp[j] = Math.max(sell, dontSell);
                } 
            }
            next = temp;
        }

        return next[1];
    }
}
