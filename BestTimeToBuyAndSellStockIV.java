// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/

//import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    // Memoization
    /* public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][2][k];

        for(int[][] i : dp)
        for(int[] j : i)
        Arrays.fill(j, -1);

        return find(0, 1, k - 1, prices, dp);
    }

    public static int find(int n, int canBuy, int pendingTx, int prices[], int[][][] dp)
    {
        if(pendingTx < 0)
        return 0;

        if(n == prices.length)
        return 0;

        if(dp[n][canBuy][pendingTx] != -1)
        return dp[n][canBuy][pendingTx];

        if(canBuy == 1)
        {
            int buy = -prices[n] + find(n + 1, 0, pendingTx, prices, dp);
            int dontBuy = find(n + 1, 1, pendingTx, prices, dp);

            return dp[n][canBuy][pendingTx] = Math.max(buy, dontBuy);
        }

        else
        {
            int sell = prices[n] + find(n + 1, 1, pendingTx - 1, prices, dp);
            int dontSell = find(n + 1, 0, pendingTx, prices, dp);

            return dp[n][canBuy][pendingTx] = Math.max(sell, dontSell);
        }
    } */

    //Tabulation
    /* public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length + 1][2 + 1][k + 1];

        for(int i = prices.length - 1; i >= 0; i--)
        {
            for(int j = 1; j >= 0; j--)
            {
                for(int l = k - 1; l >= 0; l--)
                {
                    if(j == 1)
                    {
                        int buy = -prices[i] + dp[i + 1][0][l];
                        int dontBuy = dp[i + 1][1][l];
            
                        dp[i][j][l] = Math.max(buy, dontBuy);
                    }
            
                    else
                    {
                        int sell = prices[i] + dp[i + 1][1][l + 1];
                        int dontSell = dp[i + 1][0][l];
            
                        dp[i][j][l] = Math.max(sell, dontSell);
                    } 
                }
            }
        }

        return dp[0][1][0];
    } */

    //Space Optimization
    public int maxProfit(int k, int[] prices) {
        int next[][] = new int[2 + 1][k + 1];

        for(int i = prices.length - 1; i >= 0; i--)
        {
            int temp[][] = new int[2 + 1][2 + 1];
            for(int j = 1; j >= 0; j--)
            {
                for(int l = k - 1; l >= 0; l--)
                {
                    if(j == 1)
                    {
                        int buy = -prices[i] + next[0][l];
                        int dontBuy = next[1][l];
            
                        temp[j][l] = Math.max(buy, dontBuy);
                    }
            
                    else
                    {
                        int sell = prices[i] + next[1][l + 1];
                        int dontSell = next[0][l];
            
                        temp[j][l] = Math.max(sell, dontSell);
                    } 
                }
            }
            next = temp;
        }

        return next[1][0];
    }
}
