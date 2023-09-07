// https://leetcode.com/problems/longest-repeating-character-replacement/description/

import java.util.HashMap;

/*
 * Maintain a sliding window and the count of characters in the sliding window. Also store the highest frequency element count in a variable.
 */

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int highestFreq = 0;
        int longestSubstring = 0;
        int low = 0;

        for(int high = 0; high < s.length(); high++)
        {
            int totalCharsInWindow = high - low + 1;
            char ch = s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            highestFreq = Math.max(highestFreq, map.get(ch));

            // While the extra characters in the window is more than k, reduce the sliding window.
            while(totalCharsInWindow - highestFreq > k)
            {
                map.put(s.charAt(low), map.get(s.charAt(low)) - 1);
                totalCharsInWindow--;
                low++;
            }

            longestSubstring = Math.max(longestSubstring, totalCharsInWindow);
        }

        return longestSubstring;
    }
}
