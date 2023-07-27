// https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

/*
 * Simply do a BFS traversal to get the shortest distance to all the other nodes from the source node.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraphUnitDistance {
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
		adj.add(new ArrayList<>());
		
		for(int i = 0; i < m; i++)
		{
		    adj.get(edges[i][0]).add(edges[i][1]);
		    adj.get(edges[i][1]).add(edges[i][0]);
		}
		
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(src, 0));
		
		int distance[] = new int[n];
		for(int i = 0; i < n; i++)
		distance[i] = -1;
		
		while(!queue.isEmpty())
		{
		    Pair currentVertex = queue.remove();
	        distance[currentVertex.node] = currentVertex.dist;
	        
	        for(int nVertex : adj.get(currentVertex.node))
	        {
	            if(distance[nVertex] == -1)
	            {
	                distance[nVertex] = currentVertex.dist + 1;
	                queue.add(new Pair(nVertex, currentVertex.dist + 1));
	            }
	        }
		}
		
		return distance;
    }
    
    public class Pair {
        private int node;
        private int dist;
        
        public Pair(int node, int dist)
        {
            this.node = node;
            this.dist = dist;
        }
    }
}
