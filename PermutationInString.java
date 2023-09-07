// https://leetcode.com/problems/permutation-in-string/description/

public class PermutationInString {
    /* public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        // Initialize both the arrays
        int[] charCountS1 = new int[26];
        int[] charCountS2 = new int[26];
        for(int i = 0; i < s1.length(); i++)
        {
            charCountS1[s1.charAt(i) - 'a']++;
            charCountS2[s2.charAt(i) - 'a']++;
        }

        // Find the count of equal characters
        int countOfEqualCharacters = 0;
        for(int i = 0; i < 26; i++)
        {
            if(charCountS1[i] == charCountS2[i])
            countOfEqualCharacters++;
        }

        // Check the remaining string s2.
        int low = 0;
        for(int high = s1.length(); high < s2.length(); high++)
        {
            if(countOfEqualCharacters == 26)
            return true;

            int charIndex = s2.charAt(low) - 'a';
            charCountS2[charIndex]--;

            if(charCountS1[charIndex] == charCountS2[charIndex])
            countOfEqualCharacters++;

            else if(charCountS1[charIndex] == charCountS2[charIndex] + 1)
            countOfEqualCharacters--;

            low++;

            charIndex = s2.charAt(high) - 'a';
            charCountS2[charIndex]++;

            if(charCountS1[charIndex] == charCountS2[charIndex])
            countOfEqualCharacters++;

            else if(charCountS1[charIndex] == charCountS2[charIndex] - 1)
            countOfEqualCharacters--;
        }

        return (countOfEqualCharacters == 26);
    } */

    // One HashMap only, decrementing the s1 characters and counting the number of zero count characters instead of equal characters in two hashmap
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        // Initialize both the arrays
        int[] charCount = new int[26];
        for(int i = 0; i < s1.length(); i++)
        {
            charCount[s1.charAt(i) - 'a']--;
            charCount[s2.charAt(i) - 'a']++;
        }

        // Find the count of zero count characters
        int countOfZeroCharacters = 0;
        for(int i = 0; i < 26; i++)
        {
            if(charCount[i] == 0)
            countOfZeroCharacters++;
        }

        // Check the remaining string s2.
        int low = 0;
        for(int high = s1.length(); high < s2.length(); high++)
        {
            if(countOfZeroCharacters == 26)
            return true;

            int charIndex = s2.charAt(low) - 'a';
            charCount[charIndex]--;

            if(charCount[charIndex] == 0)
            countOfZeroCharacters++;

            else if(charCount[charIndex] + 1 == 0)
            countOfZeroCharacters--;

            low++;

            charIndex = s2.charAt(high) - 'a';
            charCount[charIndex]++;

            if(charCount[charIndex] == 0)
            countOfZeroCharacters++;

            else if(charCount[charIndex] - 1 == 0)
            countOfZeroCharacters--;
        }

        return (countOfZeroCharacters == 26);
    }
}
