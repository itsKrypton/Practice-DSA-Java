// https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/ and https://practice.geeksforgeeks.org/problems/connecting-the-graph/1

/*
 * Using a DisjointSet, make union connections and find the number of componenets. To make the graph connected into a single componenent, we will need at least n - 1
 * edges, thus check if the current number of edges is at least more than n - 1, if it is, then to connect k components into a single component, we will need
 * a minimum of k - 1 edges.
 * 
 * To also find which edges were removed, before making union connections, check if the two nodes already have the same parent, if yes, that is an extra edge and you can
 * store that in a separate list.
 */

public class NumberOfOperationsToMakeGraphConnected {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);

        for(int[] connection : connections)
        ds.unionBySize(connection[0], connection[1]);

        int numberOfComponents = 0;
        for(int i = 0; i < n; i++)
        {
            if(ds.findParent(i) == i)
            numberOfComponents++;
        }

        return (connections.length >= n - 1) ? numberOfComponents - 1 : -1;
    }

    // Can also be done by finding extraEdges first, useful if the question asks for the edges removed.
    /* public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);

        int extraEdges = 0;
        for(int[] connection : connections)
        {
            if(ds.findParent(connection[0]) == ds.findParent(connection[1]))
            extraEdges++;

            ds.unionBySize(connection[0], connection[1]);
        }

        int numberOfComponents = 0;
        for(int i = 0; i < n; i++)
        {
            if(ds.findParent(i) == i)
            numberOfComponents++;
        }

        return (extraEdges >= numberOfComponents - 1) ? numberOfComponents - 1 : -1;
    } */

    public class DisjointSet {
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
