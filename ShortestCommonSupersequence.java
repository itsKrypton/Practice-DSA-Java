public class ShortestCommonSupersequence {
    /* public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];

        for(int i = 1; i <= str1.length(); i++)
        {
            for(int j = 1; j <= str2.length(); j++)
            {
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                dp[i][j] = 1 + dp[i - 1][j - 1];
        
                else
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // If length of the supersequence was asked then it would have been str1.length() + str2.length() - dp[i][j];
        // Here only the string is asked so we will take the help of DP table.

        int i = str1.length(), j = str2.length(), ind = 0;
        int length = str1.length() + str2.length() - dp[str1.length()][str2.length()];

        StringBuilder sb = new StringBuilder();
        for(ind = 0; ind < length; ind++)
        sb.append("$");
        ind--;

        while(i > 0 && j > 0)
        {
            if(str1.charAt(i - 1) == str2.charAt(j - 1))
            {
                sb.setCharAt(ind, str1.charAt(i - 1));
                ind--;
                i--;
                j--;
            }

            else if(dp[i - 1][j] > dp[i][j - 1])
            {
                sb.setCharAt(ind, str1.charAt(i - 1));
                ind--;
                i--;
            }

            else
            {
                sb.setCharAt(ind, str2.charAt(j - 1));
                ind--;
                j--;
            }
        }

        while(i > 0)
        {
            sb.setCharAt(ind, str1.charAt(i - 1));
            ind--;
            i--;
        }

        while(j > 0)
        {
            sb.setCharAt(ind, str2.charAt(j - 1));
            ind--;
            j--;   
        }

        return sb.toString();
    } */

    // Space Optimization
    public String shortestCommonSupersequence(String str1, String str2) {
        int prev[] = new int[str2.length() + 1];

        for(int i = 1; i <= str1.length(); i++)
        {
            int temp[] = new int[prev.length];
            for(int j = 1; j <= str2.length(); j++)
            {
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                temp[j] = 1 + prev[j - 1];
        
                else
                temp[j] = Math.max(prev[j], temp[j - 1]);
            }
            prev = temp;
        }

        // If length of the supersequence was asked then it would have been str1.length() + str2.length() - dp[i][j];
        // Here only the string is asked so we will take the help of DP table.

        int i = str1.length(), j = str2.length(), ind = 0;
        int length = str1.length() + str2.length() - prev[str2.length()];

        StringBuilder sb = new StringBuilder();
        for(ind = 0; ind < length; ind++)
        sb.append("$");
        ind--;

        while(i > 0 && j > 0)
        {
            if(str1.charAt(i - 1) == str2.charAt(j - 1))
            {
                sb.setCharAt(ind, str1.charAt(i - 1));
                ind--;
                i--;
                j--;
            }

            else if(prev[j] > prev[j - 1])
            {
                sb.setCharAt(ind, str1.charAt(i - 1));
                ind--;
                i--;
            }

            else
            {
                sb.setCharAt(ind, str2.charAt(j - 1));
                ind--;
                j--;
            }
        }

        while(i > 0)
        {
            sb.setCharAt(ind, str1.charAt(i - 1));
            ind--;
            i--;
        }

        while(j > 0)
        {
            sb.setCharAt(ind, str2.charAt(j - 1));
            ind--;
            j--;   
        }

        return sb.toString();
    }
}
