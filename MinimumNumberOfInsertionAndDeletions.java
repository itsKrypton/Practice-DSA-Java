// https://www.codingninjas.com/codestudio/problems/can-you-make_4244510?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

//import java.util.Arrays;

/*
 * To solve this, find the lcs between two strings and then all the remaining letter from string1 need to be deleted and all the remaining letters from string2 need
 * to be added, therefore total deletions = str1.length - lcs
 * total additions = str2.length - lcs
 * total = str1.length + str2.length - 2 * lcs
 */

public class MinimumNumberOfInsertionAndDeletions {

    //Memoization
    /* public static int canYouMake(String str, String ptr) {
        int dp[][] = new int[str.length() + 1][ptr.length() + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return str.length() + ptr.length() - (2 * find(str.length(), ptr.length(), str, ptr, dp));
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

    /* public static int canYouMake(String str, String ptr) {
        int dp[][] = new int[str.length() + 1][ptr.length() + 1];

        for(int i = 1; i <= str.length(); i++)
        {
            for(int j = 1; j <= ptr.length(); j++)
            {
                if(str.charAt(i - 1) == ptr.charAt(j - 1))
                dp[i][j] = 1 + dp[i - 1][j - 1];
        
                else
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return str.length() + ptr.length() - (2 * dp[str.length()][ptr.length()]);
    } */

    public static int canYouMake(String str, String ptr) {
        int prev[] = new int[ptr.length() + 1];

        for(int i = 1; i <= str.length(); i++)
        {
            int temp[] = new int[prev.length];
            for(int j = 1; j <= ptr.length(); j++)
            {
                if(str.charAt(i - 1) == ptr.charAt(j - 1))
                temp[j] = 1 + prev[j - 1];
        
                else
                temp[j] = Math.max(prev[j], temp[j - 1]);
            }
            prev = temp;
        }

        return str.length() + ptr.length() - (2 * prev[ptr.length()]);
    }
}
