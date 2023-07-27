// https://practice.geeksforgeeks.org/problems/word-ladder-ii/1

/*
 * Similar to Word Ladder I but here we are storing the entire sequence in the Queue. See step by step explanation.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> answers = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for(String word : wordList)
        set.add(word);

        Queue<List<String>> queue = new LinkedList<>();
        List<String> start = new ArrayList<>();
        start.add(beginWord);
        queue.add(start);
        if(set.contains(beginWord)) set.remove(beginWord);

        while(!queue.isEmpty())
        {
            HashSet<String> usedWords = new HashSet<>();
            int currentSize = queue.size();

            // Level wise BFS
            for(int i = 0; i < currentSize; i++)
            {
                List<String> currentList = queue.remove();
                String currentWord = currentList.get(currentList.size() - 1);

                // If we have found the target word
                if(currentWord.equals(endWord))
                {
                    answers.add(currentList);

                    while(!queue.isEmpty())
                    {
                        List<String> potentialAnswer = queue.remove();

                        if(potentialAnswer.get(potentialAnswer.size() - 1).equals(endWord))
                        answers.add(potentialAnswer);
                    }

                    return answers;
                }

                StringBuilder currentWordSb = new StringBuilder(currentWord);

                for(int j = 0; j < currentWordSb.length(); j++)
                {
                    for(char ch = 'a'; ch <= 'z'; ch++)
                    {
                        currentWordSb.setCharAt(j, ch);
                        String changedWord = currentWordSb.toString();

                        if(set.contains(changedWord))
                        {
                            usedWords.add(changedWord);

                            List<String> newList = new ArrayList<>(currentList);
                            newList.add(changedWord);

                            queue.add(newList);
                        }
                    }

                    currentWordSb.setCharAt(j, currentWord.charAt(j));
                }
            }

            for(String word : usedWords)
            set.remove(word);
        }

        return answers;
    }
}
