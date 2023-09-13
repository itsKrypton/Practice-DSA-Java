// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/?envType=daily-question&envId=2023-09-12

import java.util.Arrays;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        int[] freq = new int[26];

        // Store frequency of all characters in string
        for(int i = 0; i < s.length(); i++)
        freq[s.charAt(i) - 'a']++;

        // Sort the freq array
        Arrays.sort(freq);
        int deletions = 0;
        for(int i = 24; i >= 0; i--)
        {
            // There are no more characters ahead
            if(freq[i] == 0) break;

            if(freq[i] >= freq[i + 1])
            {
                int prevValue = freq[i];
                // Make the current value equal to next value - 1 or 0 whichever is larger
                freq[i] = Math.max(0, freq[i + 1] - 1);
                deletions += prevValue - freq[i];
            }
        }

        return deletions;
    }
}
