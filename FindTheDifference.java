//import java.util.HashMap;

public class FindTheDifference {

    // Another way is to xor all the characters in first string and then xor all the characters in second string. The char remaining will be the answer as the duplicates
    // are cancelled off in xor.
    /* public char findTheDifference(String s, String t) {
        char ch = 0;
        for(int i = 0; i < s.length(); i++)
            ch ^= s.charAt(i);

        for(int i = 0; i < t.length(); i++)
            ch ^= t.charAt(i);

        return ch;
    } */

    // A better way to do it, find ascii sum of all characters in t and subtract the sum of all characters in s. The remaining answer will be that extra char.
    public char findTheDifference(String s, String t) {
        // Add the sum of characters of string t
        int asciiSum = 0;
        for(int i = 0; i < t.length(); i++)
            asciiSum += t.charAt(i);

        // Remove the sum of characters of string s from the initial sum
        for(int i = 0; i < s.length(); i++)
            asciiSum -= s.charAt(i);

        return (char)asciiSum;
    }

    // Add the characters of t in a hashmap, and then remove the characters available in s from the hashmap. The character which remains is the answer.
    /* public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < t.length(); i++)
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(map.computeIfPresent(ch, (k, v) -> (map.get(ch) - 1)) == 0)
                map.remove(ch);

            // The above code does the same
            //if(map.containsKey(ch))
            //{
            //    map.put(ch, map.get(ch) - 1);

            //    if(map.get(ch) == 0)
            //        map.remove(ch);
            //}
        } 

        for(char ch : map.keySet())
            return ch;

        return ' ';
    } */
}
