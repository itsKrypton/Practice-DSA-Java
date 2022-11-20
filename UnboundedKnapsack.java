// https://www.codingninjas.com/codestudio/problems/unbounded-knapsack_1215029?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

//import java.util.Arrays;

public class UnboundedKnapsack {
    // Memoization
    /* public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return find(n - 1, w, profit, weight, dp);
    } */

    /* public static int find(int n, int maxWeight, int[] value, int[] weight, int[][] dp)
    {
        if(maxWeight == 0)
        return 0;

        if(n == 0)
        return (maxWeight/weight[0]) * value[0];

        if(dp[n][maxWeight] != -1)
        return dp[n][maxWeight];

        int pick = Integer.MIN_VALUE;
        if(weight[n] <= maxWeight)
        pick = value[n] + find(n, maxWeight - weight[n], value, weight, dp);

        int notPick = find(n - 1, maxWeight, value, weight, dp);

        return dp[n][maxWeight] = Math.max(pick, notPick);
    } */

    //Tabulation

    /* public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];

        for(int i = weight[0]; i <= w; i++)
        dp[0][i] = (i/weight[0]) * profit[0];

        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j <= w; j++)
            {
                int pick = Integer.MIN_VALUE;
                if(weight[i] <= j)
                pick = profit[i] + dp[i][j - weight[i]];
        
                int notPick = dp[i - 1][j];

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][w];
    } */

    // Space optimization
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[] prev = new int[w + 1];

        for(int i = weight[0]; i <= w; i++)
        prev[i] = (i/weight[0]) * profit[0];

        for(int i = 1; i < n; i++)
        {
            int temp[] = new int[prev.length];
            for(int j = 0; j <= w; j++)
            {
                int pick = Integer.MIN_VALUE;
                if(weight[i] <= j)
                pick = profit[i] + temp[j - weight[i]];
        
                int notPick = prev[j];

                temp[j] = Math.max(pick, notPick);
            }
            prev = temp;
        }

        return prev[w];
    }
}
