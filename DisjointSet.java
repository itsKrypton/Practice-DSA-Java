/*
 * DisjointSet tells us the parent of the given node in O(1) time and connects two nodes on the basis of it's rank or size depending on the function used. We keep a 
 * track of every nodes ultimate parent using path compression which uses recursion to set the parent of every node in the recursion path to their ultimate parent.
 * 
 * The rank array stores the height of the largest sub-tree from the given node.
 * The size array stores the total nodes below the current node.
 * The parent array stores the ultimate parent of every node.
 */

public class DisjointSet {
    private int[] rank;
    private int[] size;
    private int[] parent;

    public DisjointSet(int length)
    {
        this.rank = new int[length + 1];
        this.size = new int[length + 1];
        this.parent = new int[length + 1];

        for(int i = 0; i <= length; i++)
        {
            rank[i] = 0;
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

    public void unionByRank(int u, int v)
    {
        int parentOfU = findParent(u);
        int parentOfV = findParent(v);

        // We only perform union if parents are different, if they're same then no need.
        if(parentOfU != parentOfV)
        {
            if(rank[parentOfU] < rank[parentOfV])
            parent[parentOfU] = parentOfV;

            else if(rank[parentOfU] > rank[parentOfV])
            parent[parentOfV] = parentOfU;

            else
            {
                parent[parentOfV] = parentOfU;
                rank[parentOfU]++;
            }
        }
    }

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
