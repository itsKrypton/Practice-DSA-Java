// https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/

import java.util.Arrays;

public class WaysToReachPosWithKSteps {
    public static void main(String[] args) {
        System.out.println(numberOfWays(1, 2, 3));
    }

    public static int numberOfWays(int startPos, int endPos, int k) {
        long[][] dp = new long[5000][k + 1];

        for(long[] row : dp)
        Arrays.fill(row, -1);

        return (int)(helper(startPos, endPos, k, dp) % (long) (Math.pow(10, 9) + 7));
    }

    public static long helper(int startPos, int endPos, int k, long[][] dp)
    {
        if(startPos == endPos && k == 0)
        return 1;

        if(dp[startPos + 1000][k] != -1)
        return dp[startPos + 1000][k];

        if(Math.abs(startPos - endPos) > k)
        return 0;

        if(k < 0)
        return 0;

        return dp[startPos + 1000][k] = (long) ((helper(startPos - 1, endPos, k - 1, dp) % (long) (Math.pow(10, 9) + 7)) + (helper(startPos + 1, endPos, k - 1, dp) % (long) (Math.pow(10, 9) + 7)));
    }

    /*
     * if(startPos == endPos && k == 0)
        {
            dp[startPos + 1000]++;
            return dp[startPos + 1000];
        }

        if(dp[startPos + 1000] != -1)
        return dp[startPos + 1000];

        if(Math.abs(startPos - endPos) > k)
        {
            dp[startPos + 1000] = 0;
            return dp[startPos + 1000];
        }

        if(k < 0)
        {
            dp[startPos + 1000] = 0;
            return dp[startPos + 1000];
        }

        dp[startPos + 1000] = helper(startPos - 1, endPos, k - 1, dp) + helper(startPos + 1, endPos, k - 1, dp);
        return dp[startPos + 1000];
     */
}
