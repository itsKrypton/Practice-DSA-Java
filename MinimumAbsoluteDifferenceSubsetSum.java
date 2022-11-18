// https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

/* It's essential to understand what the DP array is storing for us to understand this problem. The last row of dp array tells us that a sum of 1 to k is
 * possible or not. With that knowledge we can calculate s1 and s2 sums and just find the minimum absolute sum between them.
 */
public class MinimumAbsoluteDifferenceSubsetSum {
    /* public static int minSubsetSumDifference(int[] arr, int n) {
        if(arr.length == 1)
        return arr[0];

        int start = 0;
        int end = arr.length - 1;
        int sum = 0;

        while(start <= end)
        {
            if(start == end)
            sum += arr[start];

            else
            sum += arr[start] + arr[end];

            start++;
            end--;
        }

		boolean dp[][] = new boolean[n][sum + 1];

        for(int i = 0; i < n; i++)
        dp[i][0] = true;

        if(arr[0] <= sum)
        dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++)
        {
            for(int j = 1; j <= sum; j++)
            {
                boolean pick = false;
                if(arr[i] <= j)
                pick = dp[i - 1][j - arr[i]];
        
                boolean notPick = dp[i - 1][j];
        
                dp[i][j] = pick || notPick;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= sum; i++)
        {
            if(dp[n-1][i])
            {
                int s1 = i;
                int s2 = sum - i;
                min = Math.min(min, Math.abs(s1 - s2));
            }
        }

        return min;
	} */

    // Space Optimization

    public static int minSubsetSumDifference(int[] arr, int n) {
        if(arr.length == 1)
        return arr[0];

        int start = 0;
        int end = arr.length - 1;
        int sum = 0;

        while(start <= end)
        {
            if(start == end)
            sum += arr[start];

            else
            sum += arr[start] + arr[end];

            start++;
            end--;
        }

		boolean prev[] = new boolean[sum + 1];

        prev[0] = true;

        if(arr[0] <= sum)
        prev[arr[0]] = true;

        for(int i = 1; i < n; i++)
        {
            boolean temp[] = new boolean[prev.length];
            temp[0] = true;
            for(int j = 1; j <= sum; j++)
            {
                boolean pick = false;
                if(arr[i] <= j)
                pick = prev[j - arr[i]];
        
                boolean notPick = prev[j];
        
                temp[j] = pick || notPick;
            }
            prev = temp;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= sum; i++)
        {
            if(prev[i])
            {
                int s1 = i;
                int s2 = sum - i;
                min = Math.min(min, Math.abs(s1 - s2));
            }
        }

        return min;
	}
}
