//import java.util.Arrays;

public class PalindromePartitioningII {
    /* public int minCut(String s) {
        int[] dp = new int[s.length()];

        Arrays.fill(dp, -1);

        return find(0, s.length() - 1, s, dp);
    }

    public static int find(int i, int j, String s, int[] dp)
    {
        if(i == j)
        return 0;
        
        if(isPalindrome(i, j, s))
        return 0;
        
        if(dp[i] != -1)
        return dp[i];

        int count = 0;
        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++)
        {
            if(isPalindrome(i, k, s))
            count = 1 + find(k + 1, j, s, dp);

            min = Math.min(min, count);
        }

        return dp[i] = min;
    } */

    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];

        for(int i = s.length() - 1; i >= 0; i--)
        {
            int count = 0;
            int min = Integer.MAX_VALUE;

            for(int k = i; k < s.length(); k++)
            {
                if(isPalindrome(i, k, s))
                count = 1 + dp[k + 1];
    
                min = Math.min(min, count);
            }
    
            dp[i] = min;        
        }

        return dp[0] - 1;
    }

    public static boolean isPalindrome(int i, int j, String s)
    {
        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
            return false;

            i++;
            j--;
        }

        return true;
    }
}
