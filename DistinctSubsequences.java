//import java.util.Arrays;

//https://leetcode.com/problems/distinct-subsequences/

public class DistinctSubsequences {
    // Recursion way to do it but gives TLE, use other approach instead.
    /* public static int numDistinct(String s, String t) {
        int numberofSubsequences = subsequence("", s, t, 0);
        return numberofSubsequences;
    }

    public static int subsequence(String pString, String uString, String targetString, int num)
    {
        if(!targetString.contains(pString))
        return num;

        if(uString.isEmpty())
        {
            if(pString.equals(targetString))
            num++;
            return num;
        }

        return subsequence(pString + uString.charAt(0), uString.substring(1), targetString, num) + subsequence(pString, uString.substring(1), targetString, num);
    } */

    // Memoization
    /* public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];

        for(int[] i : dp)
        Arrays.fill(i, -1);

        return find(s.length(), t.length(), s, t, dp);
    }

    public static int find(int n1, int n2, String s, String t, int[][] dp)
    {
        if(n2<0)
        return 1;

        if(n1<0)
        return 0;

        if(dp[n1][n2] != -1)
        return dp[n1][n2];

        int pick = 0;
        if(s.charAt(n1) == t.charAt(n2))
        pick = find(n1 - 1, n2 - 1, s, t, dp);

        int notPick = find(n1 - 1, n2, s, t, dp);

        return dp[n1][n2] = pick + notPick;
    } */

    // Tabulation here we will be shifting the indexing to right by one as base case is < 0 which is not possible for dp array
    /* public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length() + 1][t.length() + 1];

        for(int i = 0; i < s.length(); i++)
        dp[i][0] = 1;

        for(int i = 1; i <= s.length(); i++)
        {
            for(int j = 1; j <= t.length(); j++)
            {
                int pick = 0;
                if(s.charAt(i - 1) == t.charAt(j - 1))
                pick = dp[i - 1][j - 1];
        
                int notPick = dp[i - 1][j];
        
                dp[i][j] = pick + notPick;
            }
        }

        return dp[s.length()][t.length()];
    } */

    // Space Optimization
    public int numDistinct(String s, String t) {
        int prev[] = new int[t.length() + 1];

        prev[0] = 1;

        for(int i = 1; i <= s.length(); i++)
        {
            for(int j = t.length(); j >= 1; j--)
            {
                int pick = 0;
                if(s.charAt(i - 1) == t.charAt(j - 1))
                pick = prev[j - 1];
        
                int notPick = prev[j];
        
                prev[j] = pick + notPick;
            }
        }

        return prev[t.length()];
    }
}
