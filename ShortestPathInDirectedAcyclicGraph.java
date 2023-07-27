/*
 * To find the shortest path to a node, if we already know the shortest paths of all the previous nodes before current node then its easy to calculate. Hence, we first
 * find the topo sort of the given graph that makes sure that we start with the first node and make our way to the last node. Initialise a distance array with infinity
 * and the source node as 0. For every current node and it's neighbours, update the distance matrix with the minimum of current distance and new distance to reach
 * neighbour node.
 */

import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {
    public int[] shortestPath(int N,int M, int[][] edges) {
        // Adj list with neighbours and their distances.
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
		adj.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++)
		adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
		
        // Find topo sort and initialise the distance matrix
		boolean[] visited = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        int[] distance = new int[N];
        
        for(int i = 0; i < N; i++)
        {
            distance[i] = (int)1e9;
            
            if(!visited[i])
            dfs(i, adj, visited, stack);
        }
        
        distance[0] = 0;
        
        // Update distance matrix for every current node
        while(!stack.isEmpty())
        {
            int currentVertex = stack.pop();
            int currentDistance = distance[currentVertex];
            
            for(Pair nVertex : adj.get(currentVertex))
            distance[nVertex.node] = Math.min(distance[nVertex.node], currentDistance + nVertex.dist);
        }
        
        // If any node has value as 1e9 or higher that means that the node is not reachable, hence, change it to -1.
        for(int i = 0; i < N; i++)
        {
            if(distance[i] >= 1e9)
            distance[i] = -1;
        }
        
        return distance;
	}
	
	public static void dfs(int currentVertex, ArrayList<ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> stack)
    {
        visited[currentVertex] = true;
        
        for(Pair nVertex : adj.get(currentVertex))
        {
            if(!visited[nVertex.node])
            dfs(nVertex.node, adj, visited, stack);
        }
        
        stack.push(currentVertex);
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
