import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);

        /* Arrays.sort(words, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length())
                return -1;

                else if(o1.length() > o2.length())
                return 1;

                return 0;
            }
            
        }); */

        Arrays.sort(words, Comparator.comparingInt(String::length));

        int max = 1;

        for(int i = 0; i < words.length; i++)
        {
            for(int prev = 0; prev < i; prev++)
            {
                if(check(words[i], words[prev]))
                dp[i] = Math.max(dp[i], 1 + dp[prev]);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static boolean check(String word1, String word2)
    {
        if(word1.length() != word2.length() + 1)
        return false;

        int i = 0;
        int j = 0;

        while(i < word1.length())
        {
            if(word1.charAt(i) == word2.charAt(j))
            {
                i++;
                j++;
            }

            else
            i++;
        }

        return (i == word1.length() && j == word2.length());
    }
}
