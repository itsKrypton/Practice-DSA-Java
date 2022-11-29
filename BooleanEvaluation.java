// https://www.codingninjas.com/codestudio/problems/problem-name-boolean-evaluation_1214650?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1

import java.util.Arrays;

public class BooleanEvaluation {
    public static final int mod = (int)(Math.pow(10, 9)) + 7;
    public static int evaluateExp(String exp) {
        long dp[][][] = new long[exp.length()][exp.length()][2];

        for(long i[][] : dp)
        for(long j[] : i)
        Arrays.fill(j, -1);

        return (int)find(0, exp.length() - 1, 1, exp, dp);
    }

    public static long find(int i, int j, int isTrue, String exp, long[][][] dp)
    {
        if(i > j)
        return 0;

        if(i == j)
        {
            if(isTrue == 1)
            return (exp.charAt(i) == 'T') ? 1 : 0;

            else
            return (exp.charAt(i) == 'F') ? 1 : 0;
        }

        if(dp[i][j][isTrue] != -1)
        return dp[i][j][isTrue];

        long ways = 0;
        for(int k = i + 1; k <= j - 1; k += 2)
        {
            long lT = find(i, k - 1, 1, exp, dp) % mod;
            long rT = find(k + 1, j, 1, exp, dp) % mod;
            long lF = find(i, k - 1, 0, exp, dp) % mod;
            long rF = find(k + 1, j, 0, exp, dp) % mod;

            if(exp.charAt(k) == '&')
            {
                if(isTrue == 1)
                ways = (ways + (lT * rT) % mod) % mod;

                else
                ways = (ways + (lT * rF) % mod + (lF * rT) % mod + (lF * rF) % mod) % mod; 
            }

            else if(exp.charAt(k) == '|')
            {
                if(isTrue == 1)
                ways = (ways + (lT * rT) % mod + (lT * rF) % mod + (lF * rT) % mod) % mod;

                else
                ways = (ways + (lF * rF) % mod) % mod;
            }

            else
            {
                if(isTrue == 1)
                ways = (ways + (lT * rF) % mod + (lF * rT) % mod) % mod;

                else
                ways = (ways + (lF * rF) % mod + (lT * rT) % mod) % mod;
            }
        }

        return dp[i][j][isTrue] = ways;
    }
}
