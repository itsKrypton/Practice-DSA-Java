//https://leetcode.com/problems/target-sum/

// No TLE but the problem can be further improved using DP

public class TargetSum {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));    
    }

    public static int findTargetSumWays(int[] nums, int target) 
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
    }
}
