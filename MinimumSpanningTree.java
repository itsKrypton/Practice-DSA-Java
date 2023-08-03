// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Used to find MST, take a visited node and priority queue which will store neighbor nodes and weights. For Prims algo, start with any node and store all it's 
 * unvisited edges to a priority queue, take the edge with the smallest weight and mark it as visited. Continue till the queue is not empty. 
 */

public class MinimumSpanningTree {
    // Don't need parent node in Tuple for this question as it doesnt ask for MST edges, just the sum, have just added it to understand how to get mst edges as well.
    static int spanningTree(int V, int E, int edges[][]){
	    ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
	    //ArrayList<int[]> mst = new ArrayList<>();
	    boolean[] visited = new boolean[V];
	    
	    for(int i = 0; i < V; i++)
	    adj.add(new ArrayList<>());
	    
	    for(int[] edge : edges)
	    {
	        adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
	        adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
	    }
	    
	    PriorityQueue<Tuple> queue = new PriorityQueue<>((a,b) -> Integer.compare(a.weight, b.weight));
	    queue.add(new Tuple(0, 0, -1));
	    int sum = 0;
	    
	    while(!queue.isEmpty())
	    {
	        Tuple currentVertex = queue.remove();
	        
	        if(!visited[currentVertex.node])
	        {
	            visited[currentVertex.node] = true;
	            
	            if(currentVertex.parent != -1)
	            {
	                sum += currentVertex.weight;
	                //mst.add(new int[]{currentVertex.parent, currentVertex.node});
	            }
	             
	            for(int[] nVertex : adj.get(currentVertex.node))
	            {
	                if(!visited[nVertex[0]])
	                queue.add(new Tuple(nVertex[1], nVertex[0], currentVertex.node));
	            }
	        }
	    }
	    
	    return sum;
	}
	
	public static class Tuple {
	    private int weight;
	    private int node;
	    private int parent;
	    
	    public Tuple(int weight, int node, int parent)
	    {
	        this.weight = weight;
	        this.node = node;
	        this.parent = parent;
	    }
	}
}
