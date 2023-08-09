// https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

/*
 * According to Kosaraju Algo, we first find the linear ordering of the nodes to start from the first node, reverse the edges of the graph so that the strongly connected
 * components are separated (the logic is that the strongly connected components even after reversing the edges would work but the others won't) and start the dfs
 * traversal from the top of the stack and find the total components.
 */

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponentsKosarajuAlgo {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Find linear ordering
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            dfs(i, stack, visited, adj);
        }
        
        // Reverse the edges
        ArrayList<ArrayList<Integer>> reverseAdj = new ArrayList<>();
        for(int i = 0; i < V; i++)
        reverseAdj.add(new ArrayList<>());
        
        for(int i = 0; i < V; i++)
        {
            for(int nVertex : adj.get(i))
            reverseAdj.get(nVertex).add(i);
        }
        
        // Start DFS from top of stack and find number of components
        visited = new boolean[V];
        int numberOfComponents = 0;
        while(!stack.isEmpty())
        {
            int currentVertex = stack.pop();
            
            if(!visited[currentVertex])
            {
                numberOfComponents++;
                dfs(currentVertex, visited, reverseAdj);
            }
        }
        
        return numberOfComponents;
    }
    
    // dfs for linear ordering
    public void dfs(int currentVertex, Stack<Integer> stack, boolean[] visited, ArrayList<ArrayList<Integer>> adj)
    {
        visited[currentVertex] = true;
        
        for(int nVertex : adj.get(currentVertex))
        {
            if(!visited[nVertex])
            dfs(nVertex, stack, visited, adj);
        }
        
        stack.push(currentVertex);
    }
    
    // Normal dfs
    public void dfs(int currentVertex, boolean[] visited, ArrayList<ArrayList<Integer>> reverseAdj)
    {
        visited[currentVertex] = true;
        
        for(int nVertex : reverseAdj.get(currentVertex))
        {
            if(!visited[nVertex])
            dfs(nVertex, visited, reverseAdj);
        }
    }
}