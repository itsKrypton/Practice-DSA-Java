// https://leetcode.com/problems/number-of-longest-increasing-subsequence/

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequences {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int max = 1;

        for(int i = 0; i < nums.length; i++)
        {
            for(int prev = 0; prev < i; prev++)
            {
                if(nums[prev] < nums[i])
                {
                    if(1 + dp[prev] > dp[i])
                    {
                        dp[i] = 1 + dp[prev];
                        // This means that the we got a new value so inherit count value.
                        count[i] = count[prev];
                    }

                    else if(1 + dp[prev] == dp[i])
                    //This is same so add the previous count.
                    count[i] += count[prev];
                }
            }
            if(dp[i] > max)
            max = dp[i];
        }
        int nos = 0;

        for(int i = 0; i < nums.length; i++)
        if(dp[i] == max)
        nos += count[i];

        return nos;
    }
}
