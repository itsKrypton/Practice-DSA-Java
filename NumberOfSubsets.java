// https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

//import java.util.Arrays;

public class NumberOfSubsets {
    //Memoization
    /* public static int findWays(int num[], int tar) {
        int dp[][] = new int[num.length][tar + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return find(num.length - 1, tar, num, dp);
    } */

    /* public static int find(int n, int k, int[] arr, int[][] dp)
    {
        if(n == 0)
        {
            if(k == 0 && arr[0] == k)
            return 2;
            
            else if(arr[0] == k || k == 0)
            return 1;
            
            else
            return 0;
        }

        if(dp[n][k] != -1)
        return dp[n][k];

        int pick = 0;
        if(arr[n] <= k)
        pick = find(n - 1, k - arr[n], arr, dp);

        int notPick = find(n - 1, k, arr, dp);

        return dp[n][k] = pick + notPick;
    } */

    // Tabulation
    /* public static int findWays(int num[], int tar) {
        int dp[][] = new int[num.length][tar + 1];
        
        if(num[0] == 0)
        dp[0][0] = 2;

        else
        dp[0][0] = 1;

        if(num[0] != 0 && num[0] <= tar)
        dp[0][num[0]] = 1;

        for(int i = 1; i < num.length; i++)
        {
            for(int j = 0; j <= tar; j++)
            {
                int pick = 0;
                if(num[i] <= j)
                pick = dp[i - 1][j - num[i]];
        
                int notPick = dp[i - 1][j];
        
                dp[i][j] = pick + notPick;
            }
        }

        return dp[num.length - 1][tar];
    } */

    // Space Optimized
    public static int findWays(int num[], int tar) {
        int prev[] = new int[tar + 1];
        
        if(num[0] == 0)
        prev[0] = 2;

        else
        prev[0] = 1;

        if(num[0] != 0 && num[0] <= tar)
        prev[num[0]] = 1;

        for(int i = 1; i < num.length; i++)
        {
            int temp[] = new int[prev.length];
            for(int j = 0; j <= tar; j++)
            {
                int pick = 0;
                if(num[i] <= j)
                pick = prev[j - num[i]];
        
                int notPick = prev[j];
        
                temp[j] = pick + notPick;
            }
            prev = temp;
        }

        return prev[tar];
    }
}
