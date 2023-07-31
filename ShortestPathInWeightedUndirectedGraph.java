// https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Using Dijkstra's algo with an addition of parent array which keeps a track of the parent of a particular vertex.
 */

public class ShortestPathInWeightedUndirectedGraph {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		int[] distance = new int[n + 1];
		int[] parent = new int[n + 1];
		
        for(int i = 0; i <= n; i++)
		{
			distance[i] = Integer.MAX_VALUE;
			parent[i] = i;
			adj.add(new ArrayList<>());
		}
		
		distance[1] = 0;

		for(int[] edge : edges)
		{
			adj.get(edge[0]).add(new Pair(edge[2], edge[1]));
			adj.get(edge[1]).add(new Pair(edge[2], edge[0]));
		}
		
		PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        queue.add(new Pair(0, 1));
        
        while(!queue.isEmpty())
        {
            Pair currentVertex = queue.remove();
            int currentDistance = currentVertex.weight;
            
            for(Pair nVertexPair : adj.get(currentVertex.node))
            {
                int nVertex = nVertexPair.node;
                int nVertexDistance = nVertexPair.weight;
                
                if(currentDistance + nVertexDistance < distance[nVertex])
                {
                    distance[nVertex] = currentDistance + nVertexDistance;
                    parent[nVertex] = currentVertex.node;
                    queue.add(new Pair(distance[nVertex], nVertex));
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        int i = n;
    
        while(parent[i] != i)
        {
            ans.add(i);
            i = parent[i];
        }
        
        if(ans.size() == 0)
        ans.add(-1);
        
        else
        ans.add(1);

        Collections.reverse(ans);
        
        return ans;
    }
    
    public static class Pair {
        private int weight;
        private int node;

        public Pair(int weight, int node)
        {
            this.weight = weight;
            this.node = node;
        }
    }
}
