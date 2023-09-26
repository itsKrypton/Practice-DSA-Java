// https://leetcode.com/problems/remove-duplicate-letters/description/?envType=daily-question&envId=2023-09-26

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {
    /*
     * We need to efficienty use the characters such that we are only using one letter of each character present in string, and we need to make sure that the answer 
     * is a subsequence of the original string, i.e the ordering of the characters present in our answer should not change. We can keep track of the last index of 
     * all characters present in the string. It is useful as if there exists a duplicate of certain character later on in the string then we can remove it now as we
     * can be assured that we can use it again later.
     * 
     * Keep adding letters into the queue as long as the lexographical order is maintained and when it's not maintained, check if a duplicate of last character in queue
     * is present later in the string, if it is, then remove it from the queue. Do that until we can add the current character to the ans. 
     */
    public String removeDuplicateLetters(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        boolean[] usedLetters = new boolean[26];
        int[] lastIndexOfChar = new int[26];

        // Mark the last index of all characters in our string
        for(int i = 0; i < s.length(); i++)
            lastIndexOfChar[s.charAt(i) - 'a'] = i;

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            // If the current character is not used already
            if(!usedLetters[ch - 'a'])
            {
                // remove the last character of queue if it's greater than our current char and there exists a duplicate of it later in
                // the string
                while(!queue.isEmpty() && ch < queue.getLast() && i < lastIndexOfChar[queue.getLast() - 'a'])
                    usedLetters[queue.removeLast() - 'a'] = false;

                queue.addLast(ch);
                usedLetters[ch - 'a'] = true;
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!queue.isEmpty())
            ans.append(queue.removeFirst());

        return ans.toString();
    }
}
