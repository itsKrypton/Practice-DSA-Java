/*
 * For every two strings in the given dictionary, check which letter is making the difference, map that character to a node in the graph from u to v. Then simply find 
 * the linear ordering using kahns algo.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < K; i++)
        adj.add(new ArrayList<>());
        
        for(int i = 0; i < N - 1; i++)
        {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            
            for(int index = 0; index < Math.min(s1.length(), s2.length()); index++)
            {
                if(s1.charAt(index) != s2.charAt(index))
                {
                    adj.get(s1.charAt(index) - 'a').add(s2.charAt(index) - 'a');
                    break;
                }
            }
        }
        
        int[] indegree = new int[K];
        for(ArrayList<Integer> list : adj)
        {
            for(int node : list)
            indegree[node]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < K; i++)
        {
            if(indegree[i] == 0)
            queue.add(i);
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(!queue.isEmpty())
        {
            int currentNode = queue.remove();
            ans.append((char)(currentNode + (int)'a'));
            
            for(int nVertex : adj.get(currentNode))
            {
                if(--indegree[nVertex] == 0)
                queue.add(nVertex);
            }
        }
        
        return ans.toString();
    }
}
