// https://leetcode.com/problems/minimum-window-substring/description/

import java.util.HashMap;

/*
 * Similar concept as PermutationInString, take two hashmaps and store t string's character frequencies in it. Maintain a equalCount variable to check if sMap's frequency
 * is same as tMap's frequency. Increase the sliding window at every step and decrease the window size until equalCount is maintained. (If it is met already)
 */

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++)
        tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);

        HashMap<Character, Integer> sMap = new HashMap<>();
        int equalCount = 0;
        int ansStart = -1, ansEnd = -1;
        int low = 0;

        for(int high = 0; high < s.length(); high++)
        {
            char ch = s.charAt(high);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

            if(sMap.get(ch) == tMap.getOrDefault(ch, -1))
            equalCount++;

            if(equalCount == tMap.size())
            {
                while(!tMap.containsKey(s.charAt(low)) || sMap.get(s.charAt(low)) > tMap.get(s.charAt(low)))
                {
                    sMap.put(s.charAt(low), sMap.get(s.charAt(low)) - 1);

                    if(sMap.get(s.charAt(low)) == 0)
                    sMap.remove(s.charAt(low));

                    low++;
                }

                if(ansStart == -1 || high - low + 1 < ansEnd - ansStart + 1)
                {
                    ansStart = low;
                    ansEnd = high;
                }
            }
        }

        return (ansStart == -1) ? "" : s.substring(ansStart, ansEnd + 1);
    }
}
