//https://leetcode.com/problems/climbing-stairs/submissions/842635673/

import java.util.Arrays;

public class ClimbingStairs {

    //Recursive solution gives TLE
    /* public int climbStairs(int n) {
        if(n == 0)
        return 1;

        if(n == 1)
        return 1;

        return climbStairs(n - 1) + climbStairs(n - 2);
    } */

    // Using DP Memoization
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return find(n, dp);
    }

    public static int find(int n, int[] dp)
    {
        if(n == 0)
        return 1;

        if(n == 1)
        return 1;

        if(dp[n] != -1)
        return dp[n];

        return find(n - 1, dp) + find(n - 2, dp);
    }

    // Can be further simplified using tabulation by using prev2 = 1 and prev = 1 (It's copy of fibonacci). Check out fibonacci code.
}
