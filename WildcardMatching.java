// https://leetcode.com/problems/wildcard-matching/description/

//IMP

//import java.util.Arrays;

public class WildcardMatching {

    // Memoization
    /* public static boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length()][p.length()];

        for(int[] i : dp)
        Arrays.fill(i, -1);

        return find(s.length() - 1, p.length() - 1, s, p, dp);
    }

    public static boolean find(int n, int m, String s, String p, int[][] dp)
    {
        if(n < 0 && m < 0)
        return true;

        if(n < 0 && m>=0)
        {
            for(int i = m; i >= 0; i--)
            if(p.charAt(i) != '*')
            return false;

            return true;
        }

        if(m < 0 && n >= 0)
        return false;

        if(dp[n][m] != -1)
        return (dp[n][m] == 1) ? true : false;

        boolean match = false;
        if(s.charAt(n) == p.charAt(m) || p.charAt(m) == '?')
        match = find(n - 1, m - 1, s, p, dp);

        boolean checkOnStar = false;
        if(p.charAt(m) == '*')
        checkOnStar = find(n - 1, m, s, p, dp) || find(n, m - 1, s, p, dp);

        boolean notMatch = false;
        if(s.charAt(n) != p.charAt(m))
        notMatch = false;

        dp[n][m] = (match || checkOnStar || notMatch) ? 1 : 0;
        return (dp[n][m] == 1) ? true : false;
    } */

    //Tabulation here we will be shifting the indexing to right by one as base case is < 0 which is not possible for dp array
    /* public static boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;

        for(int i = 1; i <= p.length(); i++)
        {
            for(int j = 1; j <= i; j++)
            {
                if(p.charAt(j - 1) != '*')
                {
                    dp[0][i] = false;
                    break;
                }
    
                else
                dp[0][i] = true;
            }
        }

        for(int i = 1; i <= s.length(); i++)
        {
            for(int j = 1; j <= p.length(); j++)
            {
                boolean match = false;
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                match = dp[i - 1][j - 1];
        
                boolean checkOnStar = false;
                if(p.charAt(j - 1) == '*')
                checkOnStar = dp[i - 1][j] || dp[i][j - 1];
        
                boolean notMatch = false;
                if(s.charAt(i - 1) != p.charAt(j - 1))
                notMatch = false;
        
                dp[i][j] = (match || checkOnStar || notMatch);
            }
        }

        return dp[s.length()][p.length()];
    } */

    // Space Optimization
    public static boolean isMatch(String s, String p) {
        boolean prev[] = new boolean[p.length() + 1];

        prev[0] = true;

        for(int i = 1; i <= p.length(); i++)
        {
            for(int j = 1; j <= i; j++)
            {
                if(p.charAt(j - 1) != '*')
                {
                    prev[i] = false;
                    break;
                }
    
                else
                prev[i] = true;
            }
        }

        for(int i = 1; i <= s.length(); i++)
        {
            boolean temp[] = new boolean[prev.length];
            temp[0] = false;
            for(int j = 1; j <= p.length(); j++)
            {
                boolean match = false;
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                match = prev[j - 1];
        
                boolean checkOnStar = false;
                if(p.charAt(j - 1) == '*')
                checkOnStar = prev[j] || temp[j - 1];
        
                boolean notMatch = false;
                if(s.charAt(i - 1) != p.charAt(j - 1))
                notMatch = false;
        
                temp[j] = (match || checkOnStar || notMatch);
            }
            prev = temp;
        }

        return prev[p.length()];
    }
}
