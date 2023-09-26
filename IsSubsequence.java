// https://leetcode.com/problems/is-subsequence/description/?envType=daily-question&envId=2023-09-22

public class IsSubsequence {
    /* public boolean isSubsequence(String s, String t) {
        return find(0, 0, s, t);
    }

    public boolean find(int index1, int index2, String s, String t)
    {
        if(index1 == s.length())
            return true;

        if(index2 == t.length())
            return false;

        if(s.charAt(index1) == t.charAt(index2))
            return find(index1 + 1, index2 + 1, s, t);
        
        return find(index1, index2 + 1, s, t);
    } */

    // Iterative way
    public boolean isSubsequence(String s, String t) {
        /* if(s.length() == 0) return true;
        
        int index1 = 0;

        for(int index2 = 0; index2 < t.length(); index2++)
        {
            if(s.charAt(index1) == t.charAt(index2))
                index1++;

            if(index1 == s.length())
                return true;
        }

        return false; */

        // More consise way to do it
        int index1 = 0;

        for(int index2 = 0; index1 < s.length() && index2 < t.length(); index2++)
        {
            if(s.charAt(index1) == t.charAt(index2))
                index1++;
        }

        return (index1 == s.length());
    }
}
