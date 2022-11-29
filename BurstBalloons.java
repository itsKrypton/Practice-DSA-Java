// https://leetcode.com/problems/burst-balloons/description/

import java.util.ArrayList;
//import java.util.Arrays;

public class BurstBalloons {
    /* public int maxCoins(int[] nums) {
        ArrayList<Integer> modifiedNums = new ArrayList<>();
        
        modifiedNums.add(1);
        for(int i = 0; i < nums.length; i++)
        modifiedNums.add(i + 1, nums[i]);
        modifiedNums.add(1);
        
        int[][] dp = new int[modifiedNums.size()][modifiedNums.size()];

        for(int i[] : dp)
        Arrays.fill(i, -1);
        
        return find(1, nums.length, modifiedNums, dp);
    }

    public static int find(int i, int j, ArrayList<Integer> nums, int[][] dp)
    {
        if(i > j)
        return 0;

        if(dp[i][j] != -1)
        return dp[i][j];

        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++)
        {
            int ans = nums.get(i - 1) * nums.get(k) * nums.get(j + 1) + find(i, k - 1, nums, dp) + find(k + 1, j, nums, dp);
            max = Math.max(max, ans);
        }

        return dp[i][j] = max;
    } */

    //Tabulation
    public int maxCoins(int[] nums) {
        ArrayList<Integer> modifiedNums = new ArrayList<>();
        
        modifiedNums.add(1);
        for(int i = 0; i < nums.length; i++)
        modifiedNums.add(i + 1, nums[i]);
        modifiedNums.add(1);
        
        int[][] dp = new int[modifiedNums.size()][modifiedNums.size()];

        for(int i = nums.length; i >= 1; i--)
        {
            for(int j = 1; j <= nums.length; j++)
            {
                if(i > j)
                continue;

                int max = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++)
                {
                    int ans = modifiedNums.get(i - 1) * modifiedNums.get(k) * modifiedNums.get(j + 1) + dp[i][k - 1] + dp[k + 1][j];
                    max = Math.max(max, ans);
                }
        
                dp[i][j] = max;   
            }
        }
        
        return dp[1][nums.length];
    }
}
