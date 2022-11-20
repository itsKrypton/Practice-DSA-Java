// https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

//import java.util.Arrays;

public class RodCuttingProblem {
    // Memoization
    /* public static int cutRod(int price[], int n) {
		int dp[][] = new int[n][n + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return find(n - 1, n, price, dp);
	}

    public static int find(int n, int amount, int[] price, int[][] dp)
    {
        if(amount == 0)
        return 0;
        
        if(n == 0)
        return amount*price[0];

        if(dp[n][amount] != -1)
        return dp[n][amount];

        int pick = Integer.MIN_VALUE;
        if((n + 1) <= amount)
        pick = price[n] + find(n, amount - n - 1, price, dp);

        int notPick = find(n - 1, amount, price, dp);

        return dp[n][amount] = Math.max(pick, notPick);
    } */

    // Tabulation
    /* public static int cutRod(int price[], int n) {
		int dp[][] = new int[n][n + 1];

        for(int i = 0; i < n + 1; i++)
        dp[0][i] = i*price[0];

        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                int pick = Integer.MIN_VALUE;
                if((i + 1) <= j)
                pick = price[i] + dp[i][j - i - 1];
        
                int notPick = dp[i - 1][j];
        
                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][n];
	} */

    // Space Optimization
    public static int cutRod(int price[], int n) {
		int prev[] = new int[n + 1];

        for(int i = 0; i < n + 1; i++)
        prev[i] = i*price[0];

        for(int i = 1; i < n; i++)
        {
            int temp[] = new int[prev.length];
            for(int j = 0; j <= n; j++)
            {
                int pick = Integer.MIN_VALUE;
                if((i + 1) <= j)
                pick = price[i] + temp[j - i - 1];
        
                int notPick = prev[j];
        
                temp[j] = Math.max(pick, notPick);
            }
            prev = temp;
        }

        return prev[n];
	}
}
