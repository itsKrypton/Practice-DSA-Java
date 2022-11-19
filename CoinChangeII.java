// https://leetcode.com/problems/coin-change-ii/description/

//import java.util.Arrays;

public class CoinChangeII {
    // Memoization
    /* public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return find(coins.length - 1, amount, coins, dp);
    } */

    /* public static int find(int n, int amount, int[] coins, int[][] dp)
    {
        if(n == 0)
        return (amount % coins[0] == 0) ? 1 : 0;

        if(dp[n][amount] != -1)
        return dp[n][amount];

        int pick = 0;
        if(coins[n] <= amount)
        pick = find(n, amount - coins[n], coins, dp);

        int notPick = find(n - 1, amount, coins, dp);

        return dp[n][amount] = pick + notPick;
    } */

    //Tabulation
    /* public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        for(int i = 0; i <= amount; i++)
        dp[0][i] = (i % coins[0] == 0) ? 1 : 0;

        for(int i = 1; i < coins.length; i++)
        {
            for(int j = 0; j <= amount; j++)
            {
                int pick = 0;
                if(coins[i] <= j)
                pick = dp[i][j - coins[i]];
        
                int notPick = dp[i - 1][j];
        
                dp[i][j] = pick + notPick;             
            }
        }
        return dp[coins.length - 1][amount];
    } */

    //Space Optimization
    public int change(int amount, int[] coins) {
        int[] prev = new int[amount + 1];

        for(int i = 0; i <= amount; i++)
        prev[i] = (i % coins[0] == 0) ? 1 : 0;

        for(int i = 1; i < coins.length; i++)
        {
            int temp[] = new int[prev.length];
            for(int j = 0; j <= amount; j++)
            {
                int pick = 0;
                if(coins[i] <= j)
                pick = temp[j - coins[i]];
        
                int notPick = prev[j];
        
                temp[j] = pick + notPick;              
            }
            prev = temp;
        }
        return prev[amount];
    }
}
