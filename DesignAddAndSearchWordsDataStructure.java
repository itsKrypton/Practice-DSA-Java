// https://leetcode.com/problems/design-add-and-search-words-data-structure/

/*
 * Use trie data structure to add the input words and when finding the word, for every '.', we will try all the characters from a to z and whenever we get true, we 
 * return it.
 */

public class DesignAddAndSearchWordsDataStructure {
    Node root;

    public DesignAddAndSearchWordsDataStructure() {
        this.root = new Node();
    }
    
    public void addWord(String word) {
        Node current = this.root;
        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);

            if(!current.containsKey(ch))
                current.put(ch);

            current = current.getKey(ch);
        }

        current.setEnd();
    }
    
    public boolean search(String word) {
        return searchRecursively(root, 0, word);
    }

    private boolean searchRecursively(Node current, int index, String word)
    {
        if(index == word.length())
            return current.isEnd();

        if(word.charAt(index) == '.')
        {
            for(char ch = 'a'; ch <= 'z'; ch++)
            {
                if(current.containsKey(ch))
                    if(searchRecursively(current.getKey(ch), index + 1, word))
                        return true;
            }

            return false;
        }

        else
        {
            if(current.containsKey(word.charAt(index)))
                return searchRecursively(current.getKey(word.charAt(index)), index + 1, word);

            return false;
        }

    }

    public class Node {
        private Node links[];
        private boolean flag;

        public Node ()
        {
            this.links = new Node[26];
            this.flag = false;
        }

        public boolean containsKey(char ch)
        {
            return (this.links[ch - 'a'] != null);
        }

        public Node getKey(char ch)
        {
            return (this.links[ch - 'a']);
        }

        public void put(char ch)
        {
            this.links[ch - 'a'] = new Node();
        }

        public void setEnd()
        {
            this.flag = true;
        }

        public boolean isEnd()
        {
            return this.flag;
        }
    }
}
