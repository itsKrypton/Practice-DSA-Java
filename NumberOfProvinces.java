// https://leetcode.com/problems/number-of-provinces/

//import java.util.ArrayList;

public class NumberOfProvinces {
    // By creating adjacency list, extra space

    /* public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < isConnected.length; i++)
        adj.add(new ArrayList<>());

        for(int i = 0; i < isConnected.length; i++)
        {
            for(int j = 0; j < isConnected[i].length; j++)
            {
                if(isConnected[i][j] == 1 && i != j)
                {
                    adj.get(i).add(j + 1);
                    adj.get(j).add(i + 1);
                }
            }
        }

        boolean[] visited = new boolean[isConnected.length + 1];
        int numberOfProvinces = 0;
        for(int i = 0; i < isConnected.length; i++)
        {
            if(!visited[i + 1])
            {
                numberOfProvinces++;
                dfs(i + 1, adj, visited);
            }
        }

        return numberOfProvinces;
    }

    public static void dfs(int currentVertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
    {
        for(int nVertex : adj.get(currentVertex - 1))
        {
            if(!visited[nVertex])
            {
                visited[nVertex] = true;
                dfs(nVertex, adj, visited);
            }
        }
    } */

    //Without adjacency list using the given adjacency matrix

    /* public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length + 1];
        int numberOfProvinces = 0;
        for(int i = 0; i < isConnected.length; i++)
        {
            if(!visited[i + 1])
            {
                numberOfProvinces++;
                dfs(i + 1, isConnected, visited);
            }
        }

        return numberOfProvinces;
    }

    public static void dfs(int currentVertex, int[][] isConnected, boolean[] visited)
    {
        for(int nVertex = 0; nVertex < isConnected[currentVertex - 1].length; nVertex++)
        {
            if(currentVertex != (nVertex + 1) && isConnected[currentVertex - 1][nVertex] == 1 && !visited[nVertex + 1])
            {
                visited[nVertex + 1] = true;
                dfs(nVertex + 1, isConnected, visited);
            }
        }
    } */

    // Using Disjoint Set, just count the number of ultimate parents.
    // T: O(n*n + n*4alpha) ~ n^2

    public int findCircleNum(int[][] isConnected) {
        DisjointSet ds = new DisjointSet(isConnected.length);

        for(int i = 0; i < isConnected.length; i++)
        {
            for(int j = 0; j < isConnected[0].length; j++)
            {
                if(isConnected[i][j] == 1)
                ds.unionBySize(i, j);
            }
        }

        int numberOfProvinces = 0;
        for(int i = 0; i < isConnected.length; i++)
        {
            if(ds.findParent(i) == i)
            numberOfProvinces++;
        }

        return numberOfProvinces;
    }

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
