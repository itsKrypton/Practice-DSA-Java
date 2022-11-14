//https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

import java.util.ArrayList;
//import java.util.Arrays;

public class MaximumSumNonAdjacentElements {
    /* public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int dp[] = new int[nums.size() + 1];
        Arrays.fill(dp, -1);
        return find(nums, nums.size() - 1, dp);
	} */

    /* public static int find(ArrayList<Integer> nums, int index, int dp[])
    {
        if(index == 0)
        return nums.get(index);

        if(index < 0)
        return 0;

        if(dp[index] != -1)
        return dp[index];

        int pick = nums.get(index) + find(nums, index - 2, dp);
        int dontPick = 0 + find(nums, index - 1, dp);

        return dp[index] = Math.max(pick, dontPick);
    } */

    //Tabulation
    public static int find(ArrayList<Integer> nums, int index, int dp[])
    {
        dp[0] = nums.get(0);

        for(int i = 1; i < nums.size(); i++)
        {
            int pick = nums.get(i);

            if(i > 1)
            pick += dp[i - 2];

            int dontPick = 0 + dp[i - 1];

            dp[i] = Math.max(pick, dontPick);
        }

        return dp[nums.size() - 1];
    }

    //Space optimized
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int prev = nums.get(0);
        int prev2 = 0;

        for(int i = 1; i < nums.size(); i++)
        {
            int pick = nums.get(i);

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
