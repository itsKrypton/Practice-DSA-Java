// https://www.codingninjas.com/codestudio/problems/longest-common-substring_1235207?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

/* Slight variation in the Longest Common Subsequence tabulation code. */
public class LongestCommonSubstring {
    /* public static int lcs(String str1, String str2) {
		int dp[][] = new int[str1.length() + 1][str2.length() + 1];

        int ans = 0;
        for(int i = 1; i <= str1.length(); i++)
        {
            for(int j = 1; j <= str2.length(); j++)
            {
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                }
        
                else
                dp[i][j] = 0;
            }
        }
        
        return ans;
	} */

    // Space Optimized
    public static int lcs(String str1, String str2) {
		int prev[] = new int[str2.length() + 1];

        int ans = 0;
        for(int i = 1; i <= str1.length(); i++)
        {
            int temp[] = new int[prev.length];
            for(int j = 1; j <= str2.length(); j++)
            {
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                {
                    temp[j] = 1 + prev[j - 1];
                    ans = Math.max(ans, temp[j]);
                }
        
                else
                temp[j] = 0;
            }
            prev = temp;
        }
        
        return ans;
	}
}
