// https://leetcode.com/problems/word-ladder/description/

/*
 * We place all the words inside a HashSet and place the startWord inside a queue. Then just perform a BFS and for every word, replace it's characters one by one from the
 * beginning to the end from a to z and see if that word exists in the set. If it does then the sequence will be incremented and place it in the queue. When we find
 * the word that we're looking for then return the sequence.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();

        for(String word : wordList)
        set.add(word);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        if(set.contains(beginWord)) set.remove(beginWord);

        while(!queue.isEmpty())
        {
            Pair currentWord = queue.remove();
            if(currentWord.word.equals(endWord)) return currentWord.sequence;
            StringBuilder currentWordSb = new StringBuilder(currentWord.word);

            for(int i = 0; i < currentWordSb.length(); i++)
            {
                for(char ch = 'a'; ch <= 'z'; ch++)
                {
                    currentWordSb.setCharAt(i, ch);

                    if(set.contains(currentWordSb.toString()))
                    {
                        queue.add(new Pair(currentWordSb.toString(), currentWord.sequence + 1));
                        set.remove(currentWordSb.toString());
                    }
                }

                currentWordSb.setCharAt(i, currentWord.word.charAt(i));
            }
        }

        return 0;
    }

    public class Pair {
        private String word;
        private int sequence;

        public Pair(String word, int sequence)
        {
            this.word = word;
            this.sequence = sequence;
        }
    }
}
