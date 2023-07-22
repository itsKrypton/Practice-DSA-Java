// https://leetcode.com/problems/find-eventual-safe-states/description/

/*
 * We use the cycle detection technique to mark all the nodes that are not a part of a cycle and the nodes which don't lead to a cycle as all these nodes
 * will eventually go to a terminal node. Just use the logic from DetectCycleInDirectedGraph
 */

import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedList;
import java.util.List;
//import java.util.Queue;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited = new int[graph.length];
        boolean[] pathVisited = new boolean[graph.length];
        
        for(int i = 0; i < graph.length; i++)
        {
            if(visited[i] == 0)
            dfsCycle(i, visited, pathVisited, graph);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < visited.length; i++)
        if(visited[i] == 2) ans.add(i);

        return ans;
    }

    // Cycle detection
    public boolean dfsCycle(int currVertex, int[] visited, boolean[] pathVisited, int[][] graph)
    {
        visited[currVertex] = 1;
        pathVisited[currVertex] = true;

        for(int nVertex : graph[currVertex])
        {
            if(visited[nVertex] == 0)
            {
                if(dfsCycle(nVertex, visited, pathVisited, graph)) return true;
            }
            
            else if(visited[nVertex] != 0 && pathVisited[nVertex]) return true;
        }

        visited[currVertex] = 2;
        pathVisited[currVertex] = false;
        return false;
    }

    // Using Kahns algo (Topo sort)
    /*
     * As we need nodes reaching terminal nodes which have outgoing nodes as 0. We reverse the entire graph so the terminal nodes will now have incoming nodes as 0.
     * We can then just add all the nodes connected to the terminal node and not forming a cycle using Kahn's algo. Reverse the ans and return it.
     */
    /* public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<List<Integer>> revAdj = new ArrayList<>();
        
        for(int i = 0; i < V; i++)
        revAdj.add(new ArrayList<>());

        for(int i = 0; i < V; i++)
        {
            for(int node : adj.get(i))
            revAdj.get(node).add(i);
        }

        int[] indegree = new int[V];
        for(List<Integer> list : revAdj)
        {
            for(int node : list)
            indegree[node]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++)
        {
            if(indegree[i] == 0)
            queue.add(i);
        }
        
        List<Integer> ans = new ArrayList<>();
        
        while(!queue.isEmpty())
        {
            int currentNode = queue.remove();
            ans.add(currentNode);
            
            for(int nVertex : revAdj.get(currentNode))
            {
                if(--indegree[nVertex] == 0)
                queue.add(nVertex);
            }
        }
        
        Collections.sort(ans);
        return ans;
    } */
}
