// https://leetcode.com/problems/find-eventual-safe-states/description/

/*
 * We use the cycle detection technique to mark all the nodes that are not a part of a cycle and the nodes which don't lead to a cycle as safe as all these nodes
 * will eventually go to a terminal node. Just use the logic from DetectCycleInDirectedGraph
 */

import java.util.ArrayList;
import java.util.List;

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
}
