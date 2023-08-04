// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.PriorityQueue;

/*
 * Prims: Used to find MST, take a visited node and priority queue which will store neighbor nodes and weights. For Prims algo, start with any node and store all it's 
 * unvisited edges to a priority queue, take the edge with the smallest weight and mark it as visited. Continue till the queue is not empty. 
 * T: ElogE
 * S: V+E
 * 
 * Kruskals: Sort the given edges in ascending order. Use a disjointset (see it's explanation in DisjointSet) to find the ultimate parent of the two given nodes,
 * if it's not the same then consider that edge. If the parents come out to be same that means that it will form a cycle and we don't want that in MST.
 * T: E
 * S: V (In DisjointSet)
 */

public class MinimumSpanningTree {
    // Don't need parent node in Tuple for this question as it doesnt ask for MST edges, just the sum, have just added it to understand how to get mst edges as well.
    /* static int spanningTree(int V, int E, int edges[][]){
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
	} */

	static int spanningTree(int V, int E, int edges[][]){
	    //ArrayList<int[]> mst = new ArrayList<>();
	    DisjointSet ds = new DisjointSet(V);
	    Arrays.sort(edges, (a,b) -> Integer.compare(a[2], b[2]));
	    int sum = 0;
	    
	    for(int[] edge : edges)
	    {
	        if(ds.findParent(edge[0]) != ds.findParent(edge[1]))
	        {
	            //mst.add(new int[]{edge[0], edge[1]});
	            ds.unionBySize(edge[0], edge[1]);
	            sum += edge[2];
	        }
	    }
	    
	    return sum;
	}
	
	public static class DisjointSet {
        private int[] size;
        private int[] parent;
    
        public DisjointSet(int length)
        {
            this.size = new int[length + 1];
            this.parent = new int[length + 1];
    
            for(int i = 0; i <= length; i++)
            {
                size[i] = 1;
                parent[i] = i;
            }
        }
    
        // Finds ultimate parent of the given vertex in O(4 alpha) ~ O(1) uses path compression to get this
        public int findParent(int vertex)
        {
            if(this.parent[vertex] == vertex)
            return vertex;
    
            return parent[vertex] = findParent(this.parent[vertex]);
        }
    
        // Connects the parent of node u and node v depending on their ranks/size in O(4 alpha) ~ O(1)
        // Union By Size is more intuitive so use this instead of rank.
        public void unionBySize(int u, int v)
        {
            int parentOfU = findParent(u);
            int parentOfV = findParent(v);
    
            // We only perform union if parents are different, if they're same then no need.
            if(parentOfU != parentOfV)
            {
                if(size[parentOfU] < size[parentOfV])
                {
                    parent[parentOfU] = parentOfV;
                    size[parentOfV] += size[parentOfU];
                }
    
                else
                {
                    parent[parentOfV] = parentOfU;
                    size[parentOfU] += size[parentOfV];
                }
            }
        }
    }
}
