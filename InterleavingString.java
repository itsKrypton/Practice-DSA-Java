//import java.util.Arrays;

public class InterleavingString {
    // Recursion
    /* public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
        return false;

        return find(0, 0, 0, s1, s2, s3);
    }

    public boolean find(int index1, int index2, int index3, String s1, String s2, String s3)
    {
        if(index3 == s3.length())
        return true;

        // If the character matches with the character from s1
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3))
        {
            if(find(index1 + 1, index2, index3 + 1, s1, s2, s3))
            return true;
        }

        // If the character matches with the character from s2
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3))
        {
            if(find(index1, index2 + 1, index3 + 1, s1, s2, s3))
            return true;
        }

        return false;
    } */

    // Memoization
    /* public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
        return false;

        int[][][] dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];

        for(int[][] i : dp)
            for(int j[] : i)
                Arrays.fill(j, -1);


        return find(0, 0, 0, s1, s2, s3, dp);
    }

    public boolean find(int index1, int index2, int index3, String s1, String s2, String s3, int[][][] dp)
    {
        if(index3 == s3.length())
        {
            dp[index1][index2][index3] = 1;
            return true;
        }

        if(dp[index1][index2][index3] != -1)
        return (dp[index1][index2][index3] == 1) ? true : false;

        // If the character matches with the character from s1
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3))
        {
            if(find(index1 + 1, index2, index3 + 1, s1, s2, s3, dp))
            {
                dp[index1][index2][index3] = 1;
                return true;
            }
        }

        // If the character matches with the character from s2
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3))
        {
            if(find(index1, index2 + 1, index3 + 1, s1, s2, s3, dp))
            {
                dp[index1][index2][index3] = 1;
                return true;
            }
        }

        dp[index1][index2][index3] = 0;
        return false;
    } */

    // Optimized memoization from 3d dp to 2d dp. After observing, we find that we don't need to carry index3 as it will always be index1 + index2;
    /* public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
        return false;

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for(int[] i : dp)
            Arrays.fill(i, -1);

        return find(0, 0, s1, s2, s3, dp);
    }

    public boolean find(int index1, int index2, String s1, String s2, String s3, int[][] dp)
    {
        if(index1 + index2 == s3.length())
        {
            dp[index1][index2] = 1;
            return true;
        }

        if(dp[index1][index2] != -1)
        return (dp[index1][index2] == 1) ? true : false;

        // If the character matches with the character from s1
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index1 + index2))
        {
            if(find(index1 + 1, index2, s1, s2, s3, dp))
            {
                dp[index1][index2] = 1;
                return true;
            }
        }

        // If the character matches with the character from s2
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index1 + index2))
        {
            if(find(index1, index2 + 1, s1, s2, s3, dp))
            {
                dp[index1][index2] = 1;
                return true;
            }
        }

        dp[index1][index2] = 0;
        return false;
    } */

    // Tabulation
    /* public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
        return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        dp[s1.length()][s2.length()] = true;

        for(int i = s1.length(); i >= 0; i--)
        {
            for(int j = s2.length(); j >= 0; j--)
            {
                if(i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j])
                dp[i][j] = true;

                if(j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1])
                dp[i][j] = true;
            }
        }

        return dp[0][0];
    } */

    // Space - Optimized - 1D DP
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
        return false;

        boolean[] next = new boolean[s2.length() + 1];

        next[s2.length()] = true;

        for(int i = s1.length(); i >= 0; i--)
        {
            boolean[] temp = new boolean[next.length];

            if(i == s1.length())
            temp[s2.length()] = true;

            for(int j = s2.length(); j >= 0; j--)
            {
                if(i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && next[j])
                temp[j] = true;

                if(j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && temp[j + 1])
                temp[j] = true;
            }

            next = temp;
        }

        return next[0];
    }
}
