//https://leetcode.com/problems/distinct-subsequences/

// Not solved yet gives TLE need to use DP

public class DistinctSubsequences {
    public static void main(String args[])
    {
        String test = "abec";
        System.out.println(numDistinct(test, "bc"));
    }

    public static int numDistinct(String s, String t) {
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
    }
}
