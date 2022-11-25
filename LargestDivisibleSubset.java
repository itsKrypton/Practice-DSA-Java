// https://leetcode.com/problems/largest-divisible-subset/description/

/* 
 * This problem is a slight change to LIS problem. If we sort the given array we then just need to find the longest divisible subsequence which can be done by making
 * slight change to the LIS code, we add nums[i] % nums[prev] instead of check if nums[prev] < nums[i] for LIS. Rest is the same.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];

        Arrays.fill(dp, 1);

        Arrays.sort(nums);

        int max = 1;
        int lastIndex = 0;

        for(int i = 0; i < nums.length; i++)
        {
            hash[i] = i;
            for(int prev = 0; prev < i; prev++)
            {
                if((nums[i] % nums[prev] == 0) && (1 + dp[prev] > dp[i]))
                {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i] > max)
            {
                max = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(0, nums[lastIndex]);

        while(hash[lastIndex] != lastIndex)
        {
            lastIndex = hash[lastIndex];
            answer.add(0, nums[lastIndex]);
        }

        return answer;
    }
}
