// https://leetcode.com/problems/making-a-large-island/description/ and https://practice.geeksforgeeks.org/problems/maximum-connected-group/1

import java.util.HashSet;

/*
 * Using DisjointSet, we first make the union connections of all the ones and form components and find their current sizes. We then try converting the zeroes to ones
 * one by one and check it's four sides, if it has a component, see if it's a unique component by storing it's parent in a hashset. If it's a unique component then
 * store it's size. Check all the four sides. Do this for all the zeroes, and find the largest island.
 */

public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        DisjointSet ds = new DisjointSet(grid.length * grid.length);
        int[] xDirections = new int[]{0, -1, 0, +1};
        int[] yDirections = new int[]{-1, 0, +1, 0};

        // Creating union connections and finding current island sizes
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid.length; j++)
            {
                if(grid[i][j] == 1)
                {
                    int currentVertex = (i * grid.length) + j;
                    for(int k = 0; k < xDirections.length; k++)
                    {
                        int nRow = i + xDirections[k];
                        int nCol = j + yDirections[k];

                        if(isSafe(nRow, nCol, grid))
                        {
                            int nVertex = (nRow * grid.length) + nCol;
                            ds.unionBySize(currentVertex, nVertex);
                        }
                    }
                }
            }
        }

        // Making larger island
        int largestIsland = 1;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid.length; j++)
            {
                int currentVertex = (i * grid.length) + j;

                if(grid[i][j] == 1)
                largestIsland = Math.max(largestIsland, ds.getSize(currentVertex));

                else
                {
                    int currentIslandSize = 1;
                    HashSet<Integer> uniqueIslands = new HashSet<>();

                    for(int k = 0; k < xDirections.length; k++)
                    {
                        int nRow = i + xDirections[k];
                        int nCol = j + yDirections[k];
                        int nVertex = (nRow * grid.length) + nCol;

                        if(isSafe(nRow, nCol, grid) && uniqueIslands.add(ds.findParent(nVertex)))
                        currentIslandSize += ds.getSize(nVertex);
                    }

                    largestIsland = Math.max(largestIsland, currentIslandSize);
                }
            }
        }

        return largestIsland;
    }

    public boolean isSafe(int x, int y, int[][] grid)
    {
        return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1);
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

        // Returns the size of the current vertex's parents component size
        public int getSize(int vertex)
        {
            return size[findParent(vertex)];
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
