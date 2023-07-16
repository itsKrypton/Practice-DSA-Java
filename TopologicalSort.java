// https://practice.geeksforgeeks.org/problems/topological-sort/1

/*
 * The idea is, after all the dfs traversals of a node is done, we put that node in a stack. All the nodes below the stack would have been placed in it only if it has 
 * been already been visited, that means, those nodes are after the current node. So the stack will naturally follow the linear ordering from top to bottom, with the
 * bottom nodes being after the upper nodes.
 */

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            dfs(i, adj, visited, stack);
        }
        
        int[] ans = new int[V];
        int i = 0;
        
        while(!stack.isEmpty())
        ans[i++] = stack.pop();
        
        return ans;
    }
    
    public static void dfs(int currentVertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack)
    {
        visited[currentVertex] = true;
        
        for(int nVertex : adj.get(currentVertex))
        {
            if(!visited[nVertex])
            dfs(nVertex, adj, visited, stack);
        }
        
        stack.push(currentVertex);
    }
}
