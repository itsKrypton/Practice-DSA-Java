// 

//import java.util.Arrays;

// To make any string palindrome, you can just copy the string, reverse it and add it to the back but this takes the maximum steps.
// E.g saurav -> sauravvaruas this is a palindrome but took 6 insertions
// You could instead find the longest palindromic subsequence, keep it intact and reverse and insert the rest of the letters at the appropriate indices.
// E.g saurav -> aua is palindrome so svaruravs can be an answer by adding rest of the letters so answer would be length of string - length of longest palindromic 
// subsequence.

// Memoization
public class MinimumInsertionsStringPalindrome {
    /* public int minInsertions(String s) {
        int dp[][] = new int[s.length() + 1][s.length() + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        StringBuilder sb = new StringBuilder(s);

        return s.length() - find(s.length(), s.length(), s, sb.reverse().toString(), dp);
    }

    public static int find(int n1, int n2, String text1, String text2, int[][] dp)
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

        return s.length() - dp[s.length()][s2.length()];
    } */

    //Space optimized

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

        return s.length() - prev[s2.length()];
    }
}
