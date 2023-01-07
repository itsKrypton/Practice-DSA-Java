// https://leetcode.com/problems/word-pattern/description/

/*
 * Map the pattern characters to words in the string, if at any point the value of value in the table for a specific key is not equal to the current word in the string
 * then you can return false. If it's a unique pair of key and value then add it to the hashtable.
 * 
 * T: O(n^2) S: O(n)
 */

import java.util.Hashtable;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(pattern.length() != words.length) return false;

        Hashtable<Character, String> table = new Hashtable<>();

        for(int i = 0; i < words.length; i++)
        {
            boolean containsKey = table.containsKey(pattern.charAt(i));
            
            if(!containsKey && table.containsValue(words[i])) return false;
            if(containsKey && !table.get(pattern.charAt(i)).equals(words[i])) return false;

            table.put(pattern.charAt(i), words[i]);
        }

        return true;
    }
}
