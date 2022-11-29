//import java.util.Arrays;

public class PartitionArrayForMaximumSum {

    // Memoization
    /* public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];

        Arrays.fill(dp, -1);

        return find(0, arr.length - 1, k, arr, dp);
    }

    public static int find(int i, int n, int k, int[] arr, int[] dp)
    {
        if(i > n)
        return 0;

        if(dp[i] != -1)
        return dp[i];

        int max = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int j = 0; j < k && i + j <= n; j++)
        {
            maxValue = Math.max(maxValue, arr[i + j]);
            int ans = (maxValue * (j + 1)) + find(i + (j + 1), n, k, arr, dp);

            max = Math.max(max, ans);
        }

        return dp[i] = max;
    } */

    // Tabulation
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];

        dp[arr.length - 1] = arr[arr.length - 1];

        for(int i = arr.length - 1; i >= 0; i--)
        {
            int max = Integer.MIN_VALUE;
            int maxValue = Integer.MIN_VALUE;
            for(int j = 0; j < k && i + j <= arr.length - 1; j++)
            {
                maxValue = Math.max(maxValue, arr[i + j]);
                int ans = (maxValue * (j + 1)) + dp[i + (j + 1)];
    
                max = Math.max(max, ans);
            }
    
            dp[i] = max;
        }

        return dp[0];
    }
}
