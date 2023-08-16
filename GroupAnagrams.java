// https://leetcode.com/problems/group-anagrams/description/
import java.util.*;

/*
 * Sort the given string so that all anagrams of this string would have the same sorted string, this can be used as a key in the hashmap. Then just simply store all
 * the anagrams under the same sortedString key and later add it to the ans list.
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs)
        {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            map.putIfAbsent(sortedString, new ArrayList<>());
            map.get(sortedString).add(s);
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet())
        ans.add(entry.getValue());

        return ans;
    }
}
