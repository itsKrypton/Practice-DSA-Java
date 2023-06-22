// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

/*
 * Here we need to check if a vertex is already visited on the current path, if it is then return true else false. For that, we use a second visited array called
 * pathVisited which keeps a track of vertex visited in the current path, we basically backtrack before returning from a function call to clear the path.
 */

// Can also be done using a single visited array and marking path visited and visited by two different numbers
import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        
        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                pathVisited[i] = true;
                if(dfs(i, visited, pathVisited, adj)) return true;
                pathVisited[i] = false;
            }
        }
        
        return false;
    }
    
    public boolean dfs(int currVertex, boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> adj)
    {
        for(int nVertex : adj.get(currVertex))
        {
            if(!visited[nVertex])
            {
                visited[nVertex] = true;
                pathVisited[nVertex] = true;
                if(dfs(nVertex, visited, pathVisited, adj)) return true;
                pathVisited[nVertex] = false;
            }
            
            else if(visited[nVertex] && pathVisited[nVertex]) return true;
        }
        
        return false;
    }
}
