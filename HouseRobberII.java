import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 1)
        return nums[0];
        
        //int dp[] = new int[nums.length + 1];
        //Arrays.fill(dp, -1);

        int[] leftHouses = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] rightHouses = Arrays.copyOfRange(nums, 1, nums.length);

        //int leftSum = find(leftHouses, leftHouses.length - 1);
        //Arrays.fill(dp, -1);
        //int rightSum = find(rightHouses, rightHouses.length - 1);

        int leftSum = find(leftHouses);
        int rightSum = find(rightHouses);

        return Math.max(leftSum, rightSum);
    }
    
    //Memoization
    /* public static int find(int[] nums, int index, int dp[])
    {
        if(index == 0)
        return nums[index];

        if(index < 0)
        return 0;

        if(dp[index] != -1)
        return dp[index];

        int pick = nums[index] + find(nums, index - 2, dp);
        int dontPick = 0 + find(nums, index - 1, dp);

        return dp[index] = Math.max(pick, dontPick);
    } */

    //Tabulation
    /* public static int find(int[] nums, int index, int dp[])
    {
        dp[0] = nums[index];

        for(int i = 1; i < nums.length; i++)
        {
            int pick = nums[i];

            if(i > 1)
            pick += dp[i - 2];

            int dontPick = 0 + dp[i - 1];

            dp[i] = Math.max(pick, dontPick);
        }

        return dp[nums.length - 1];
    } */

    //Space optimized
    public static int find(int[] nums)
    {
        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < nums.length; i++)
        {
            int pick = nums[i];

            if(i > 1)
            pick += prev2;

            int dontPick = 0 + prev;

            int currI = Math.max(pick, dontPick);
            prev2 = prev;
            prev = currI;
        }

        return prev;
    }
}
