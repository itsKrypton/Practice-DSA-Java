//import java.util.Arrays;

public class JumpGame {
    //Memoization
    /* public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, -1);

        return find(0, nums, dp);
    }

    public boolean find(int index, int[] nums, int[] dp)
    {
        if(index >= nums.length)
        return false;

        if(index == nums.length - 1)
        return true;

        if(dp[index] != -1)
        return (dp[index] == 1) ? true : false;

        boolean ans = false;
        for(int i = 1; i <= nums[index]; i++)
        {
            ans = find(index + i, nums, dp);
            if(ans) return true;
        }

        dp[index] = 0;
        return false;
    } */

    //Tabulation
    /* public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];

        return find(nums, dp);
    }

    public boolean find(int[] nums, boolean[] dp)
    {
        dp[nums.length - 1] = true;

        for(int index = nums.length - 2; index >= 0; index--)
        {
            for(int i = 1; i <= nums[index] && (index + i) < nums.length; i++)
            {
                dp[index] = dp[index + i];
                if(dp[index]) break;
            }
        }

        return dp[0];
    } */

    // Better solution T: O(n) S: O(1)

    // The idea is to find the maximum distance we can go from a specific index and we keep finding the maximum from every index. If at any point our index exceeds the
    // maximum distance we can return false directly.
    public boolean canJump(int[] nums) {
        int maxDistance = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(i > maxDistance) return false;
            maxDistance = Math.max(maxDistance, i + nums[i]);
        }
        return true;
    }
}
