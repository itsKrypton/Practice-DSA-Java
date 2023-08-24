// https://leetcode.com/problems/reorganize-string/description/

import java.util.HashMap;
import java.util.PriorityQueue;

/*
 * Have a priority queue and a hashmap to sort characters on the basis of their frequencies and store the characters and their frequencies respectively. Get the two
 * highest frequency characters and add it to the answer. Decrement their frequencies and add them back to the priority queue if their frequency is greater than 1.
 */

public class ReorganizeString {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        PriorityQueue<Character> queue = new PriorityQueue<>((a,b) -> Integer.compare(map.get(b), map.get(a)));
        queue.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty())
        {
            if(queue.size() == 1)
            {
                if(map.get(queue.peek()) == 1)
                sb.append(queue.remove());

                else
                return "";
            }

            else
            {
                char first = queue.remove();
                char second = queue.remove();

                sb.append(first);
                sb.append(second);
                
                if(map.get(first) == 1)
                map.remove(first);

                else
                {
                    map.put(first, map.get(first) - 1);
                    queue.add(first);
                }

                if(map.get(second) == 1)
                map.remove(second);

                else
                {
                    map.put(second, map.get(second) - 1);
                    queue.add(second);
                }
            }
        }

        return sb.toString();
    }
}
