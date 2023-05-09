// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.ArrayList;

public class DFSOfGraph {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> dfs = new ArrayList<>();

        visited[0] = true;
        dfs.add(0);
        dfs(0, adj, dfs, visited);

        return dfs;
    }

    public static void dfs(int currentVertex, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, boolean[] visited)
    {
        for(int nVertex : adj.get(currentVertex))
        {
            if(!visited[nVertex])
            {
                visited[nVertex] = true;
                dfs.add(nVertex);
                dfs(nVertex, adj, dfs, visited);
            }
        }
    }
}
