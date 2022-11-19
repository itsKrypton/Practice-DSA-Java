// https://leetcode.com/problems/coin-change/description/

//import java.util.Arrays;

public class CoinChange {
    // Memoization

    /* public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        int totalCoins = find(coins.length - 1, amount, coins, dp);
        return (totalCoins >= (int)Math.pow(10,9)) ? -1 : totalCoins;
    } */

    /* public static int find(int n, int amount, int[] coins, int[][] dp)
    {
        if(n == 0)
        return (amount % coins[0] == 0) ? amount/coins[0] : (int)Math.pow(10, 9);

        if(dp[n][amount] != -1)
        return dp[n][amount];

        int pick = Integer.MAX_VALUE;
        if(coins[n] <= amount)
        pick = 1 + find(n, amount - coins[n], coins, dp);

        int notPick = find(n - 1, amount, coins, dp);

        return dp[n][amount] = Math.min(pick, notPick);
    } */

    //Tabulation

    /* public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        for(int i = 0; i <= amount; i++)
        dp[0][i] = (i % coins[0] == 0) ? i/coins[0] : (int)Math.pow(10, 9);

        for(int i = 1; i < coins.length; i++)
        {
            for(int j = 0; j <= amount; j++)
            {
                int pick = Integer.MAX_VALUE;
                if(coins[i] <= j)
                pick = 1 + dp[i][j - coins[i]];
        
                int notPick = dp[i - 1][j];
        
                dp[i][j] = Math.min(pick, notPick);              
            }
        }
        return (dp[coins.length - 1][amount] >= (int)Math.pow(10,9)) ? -1 : dp[coins.length - 1][amount];
    } */

    // Space optimization
    public int coinChange(int[] coins, int amount) {
        int[] prev = new int[amount + 1];

        for(int i = 0; i <= amount; i++)
        prev[i] = (i % coins[0] == 0) ? i/coins[0] : (int)Math.pow(10, 9);

        for(int i = 1; i < coins.length; i++)
        {
            int temp[] = new int[prev.length];
            for(int j = 0; j <= amount; j++)
            {
                int pick = Integer.MAX_VALUE;
                if(coins[i] <= j)
                pick = 1 + temp[j - coins[i]];
        
                int notPick = prev[j];
        
                temp[j] = Math.min(pick, notPick);              
            }
            prev = temp;
        }
        return (prev[amount] >= (int)Math.pow(10,9)) ? -1 : prev[amount];
    }
}
