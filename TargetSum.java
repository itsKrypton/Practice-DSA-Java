//import java.util.Arrays;

//https://leetcode.com/problems/target-sum/

// This problem is basically same as Partition with given difference, please refer to that problem. (https://www.codingninjas.com/codestudio/problems/partitions-with-given-difference_3751628?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos)

public class TargetSum {

    // Can also be done using normal recursion

    /* public static int findTargetSumWays(int[] nums, int target) 
    {
        return helper(nums, target, 0, 0);
    }

    public static int helper(int[] nums, int target, int currentSum, int index)
    {
        if(index == nums.length)
        {
            if(currentSum == target)
            return 1;

            return 0;
        }

        int count = 0;

        count += helper(nums, target, currentSum - nums[index], index + 1);
        count += helper(nums, target, currentSum + nums[index], index + 1);

        return count;
    } */

    // Memoization
    /* public static int findTargetSumWays(int[] nums, int target) 
    {
        int sum = 0;
        
        for(int i : nums)
        sum += i;
        
        int newTarget = (sum - target) / 2;

        if((sum - target) < 0 || ((sum - target) % 2) == 1)
        return 0;

        int dp[][] = new int[nums.length][newTarget + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return find(nums.length - 1, newTarget, nums, dp);
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

        return dp[n][k] = (pick + notPick);
    } */

    // Tabulation
    /* public static int findTargetSumWays(int[] nums, int target) 
    {
        int sum = 0;
        
        for(int i : nums)
        sum += i;
        
        int newTarget = (sum - target) / 2;

        if((sum - target) < 0 || ((sum - target) % 2) == 1)
        return 0;

        int dp[][] = new int[nums.length][newTarget + 1];

        if(nums[0] == 0)
        dp[0][0] = 2;

        else
        dp[0][0] = 1;

        if(nums[0] != 0 && nums[0] <= newTarget)
        dp[0][nums[0]] = 1;

        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 0; j <= newTarget; j++)
            {
                int pick = 0;
                if(nums[i] <= j)
                pick = dp[i - 1][j - nums[i]];
        
                int notPick = dp[i - 1][j];
        
                dp[i][j] = (pick + notPick);
            }
        }

        return dp[nums.length - 1][newTarget];
    } */

    // Space Optimization
    public static int findTargetSumWays(int[] nums, int target) 
    {
        int sum = 0;
        
        for(int i : nums)
        sum += i;
        
        int newTarget = (sum - target) / 2;

        if((sum - target) < 0 || ((sum - target) % 2) == 1)
        return 0;

        int prev[] = new int[newTarget + 1];

        if(nums[0] == 0)
        prev[0] = 2;

        else
        prev[0] = 1;

        if(nums[0] != 0 && nums[0] <= newTarget)
        prev[nums[0]] = 1;

        for(int i = 1; i < nums.length; i++)
        {
            int temp[] = new int[prev.length];
            for(int j = 0; j <= newTarget; j++)
            {
                int pick = 0;
                if(nums[i] <= j)
                pick = prev[j - nums[i]];
        
                int notPick = prev[j];
        
                temp[j] = (pick + notPick);
            }
            prev = temp;
        }

        return prev[newTarget];
    }
}
