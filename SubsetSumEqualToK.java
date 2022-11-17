// https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954?leftPanelTab=0

//import java.util.Arrays;

public class SubsetSumEqualToK {
    // Memoization
    /* public static boolean subsetSumToK(int n, int k, int arr[]){
        int dp[][] = new int[n][k];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return find(n - 1, k, arr, dp);
    } */

    /* public static boolean find(int n, int k, int[] arr, int[][] dp)
    {
        if(k == 0)
        return true;

        if(n == 0)
        return (arr[n] == k);

        if(dp[n][k] != -1)
        return dp[n][k] == 1 ? true : false;

        boolean pick = false;
        if(arr[n] <= k)
        pick = find(n - 1, k - arr[n], arr, dp);

        boolean notPick = find(n - 1, k, arr, dp);

        dp[n][k] = pick || notPick ? 1 : 0;
        return pick || notPick;
    } */

    // Tabulation

    /* public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean dp[][] = new boolean[n][k + 1];

        for(int i = 0; i < n; i++)
        dp[i][0] = true;

        if(arr[0] <= k)
        dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++)
        {
            for(int j = 1; j <= k; j++)
            {
                boolean pick = false;
                if(arr[i] <= j)
                pick = dp[i - 1][j - arr[i]];
        
                boolean notPick = dp[i - 1][j];
        
                dp[i][j] = pick || notPick;
            }
        }

        return dp[n - 1][k];
    } */

    // Space Optimized
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean prev[] = new boolean[k + 1];

        prev[0] = true;

        if(arr[0] <= k)
        prev[arr[0]] = true;

        for(int i = 1; i < n; i++)
        {
            boolean temp[] = new boolean[prev.length];
            temp[0] = true;
            for(int j = 1; j <= k; j++)
            {
                boolean pick = false;
                if(arr[i] <= j)
                pick = prev[j - arr[i]];
        
                boolean notPick = prev[j];
        
                temp[j] = pick || notPick;
            }
            prev = temp;
        }

        return prev[k];
    }
}
