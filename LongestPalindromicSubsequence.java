//import java.util.Arrays;

// This problem is similar to LCS, just use the reverse of the given string as string 2 and find the longest common subsequence. As the string is reversed the common
// string has to be the palindromic string as it's the same front the front and back.

public class LongestPalindromicSubsequence {
    // Memoization
    /* public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[s.length() + 1][s.length() + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        StringBuilder sb = new StringBuilder(s);

        return find(s.length(), s.length(), s, sb.reverse().toString(), dp);
    } */

    /* public static int find(int n1, int n2, String text1, String text2, int[][] dp)
    {
        if(n1 == 0 || n2 == 0)
        return 0;

        if(dp[n1][n2] != -1)
        return dp[n1][n2];

        if(text1.charAt(n1 - 1) == text2.charAt(n2 - 1))
        return dp[n1][n2] = 1 + find(n1 - 1, n2 - 1, text1, text2, dp);

        return dp[n1][n2] = Math.max(find(n1 - 1, n2, text1, text2, dp), find(n1, n2 - 1, text1, text2, dp));
    } */

    //Tabulation
    /* public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();

        int dp[][] = new int[s.length() + 1][s2.length() + 1];

        for(int i = 1; i <= s.length(); i++)
        {
            for(int j = 1; j <= s2.length(); j++)
            {
                if(s.charAt(i - 1) == s2.charAt(j - 1))
                dp[i][j] = 1 + dp[i - 1][j - 1];
        
                else
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[s.length()][s2.length()];
    } */

    // Space Optimized
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();

        int prev[] = new int[s2.length() + 1];

        for(int i = 1; i <= s.length(); i++)
        {
            int temp[] = new int[prev.length];
            for(int j = 1; j <= s2.length(); j++)
            {
                if(s.charAt(i - 1) == s2.charAt(j - 1))
                temp[j] = 1 + prev[j - 1];
        
                else
                temp[j] = Math.max(prev[j], temp[j - 1]);
            }
            prev = temp;
        }

        return prev[s2.length()];
    }
}
