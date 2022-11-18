// https://www.codingninjas.com/codestudio/problems/partitions-with-given-difference_3751628?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

//import java.util.Arrays;

public class PartitionsWithGivenDifference {
    static int mod = (int)Math.pow(10, 9) + 7;
    /* public static int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        
        for(int i : arr)
        sum += i;
        
        int target = (sum - d) / 2;

        if((sum - d) < 0 || ((sum - d) % 2) == 1)
        return 0;

        int dp[][] = new int[n][target + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return find(n - 1, target, arr, dp);
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

        return dp[n][k] = (pick + notPick) % mod;
    } */

    // Tabulation
    /* public static int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        
        for(int i : arr)
        sum += i;
        
        int target = (sum - d) / 2;

        if((sum - d) < 0 || ((sum - d) % 2) == 1)
        return 0;

        int dp[][] = new int[n][target + 1];

        if(arr[0] == 0)
        dp[0][0] = 2;

        else
        dp[0][0] = 1;

        if(arr[0] != 0 && arr[0] <= target)
        dp[0][arr[0]] = 1;

        for(int i = 1; i < arr.length; i++)
        {
            for(int j = 0; j <= target; j++)
            {
                int pick = 0;
                if(arr[i] <= j)
                pick = dp[i - 1][j - arr[i]];
        
                int notPick = dp[i - 1][j];
        
                dp[i][j] = (pick + notPick) % mod;
            }
        }

        return dp[arr.length - 1][target];
	} */

    // Space Optimization
    public static int countPartitions(int n, int d, int[] arr) {
        int sum = 0;
        
        for(int i : arr)
        sum += i;
        
        int target = (sum - d) / 2;

        if((sum - d) < 0 || ((sum - d) % 2) == 1)
        return 0;

        int prev[] = new int[target + 1];

        if(arr[0] == 0)
        prev[0] = 2;

        else
        prev[0] = 1;

        if(arr[0] != 0 && arr[0] <= target)
        prev[arr[0]] = 1;

        for(int i = 1; i < arr.length; i++)
        {
            int temp[] = new int[prev.length];
            for(int j = 0; j <= target; j++)
            {
                int pick = 0;
                if(arr[i] <= j)
                pick = prev[j - arr[i]];
        
                int notPick = prev[j];
        
                temp[j] = (pick + notPick) % mod;
            }
            prev = temp;
        }

        return prev[target];
	}
}
