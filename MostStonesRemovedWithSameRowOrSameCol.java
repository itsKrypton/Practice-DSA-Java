// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/ or https://practice.geeksforgeeks.org/problems/maximum-stone-removal-1662179442/1

/*
 * We can consider the rows and cols to be individual nodes of DisjointSet and we simply connect the rows and cols where the stones lie. We find the total components
 * having more than one stones and the answer will be total stones (n) - no of components.
 * 
 * For two components of size 4 and 3. The answer would be 4 - 1 + 3 - 1 = 5, that means we can remove 5 stones,
 * 
 * this boils down to 
 * 
 * x1 - 1 + x2 - 1 -> x1 + x2 - (1 + 1) which is nothing but n - (no. of components).
 */

public class MostStonesRemovedWithSameRowOrSameCol {
    public int removeStones(int[][] stones) {
        // Find the max row and max col in the given input
        int maxRow = 0, maxCol = 0;

        for(int[] stone : stones)
        {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        // Make DisjointSet of that maxrow + maxcol + 1 size.
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);

        // Connect rows and cols where the stones lie
        for(int[] stone : stones)
        ds.unionBySize(stone[0], stone[1] + maxRow + 1);

        // Find the total components which have more than one stone.
        int numberOfComponents = 0;
        for(int i = 0; i < maxRow + maxCol + 2; i++)
        {
            if(ds.findParent(i) == i && ds.getSize(i) > 1)
            numberOfComponents++;
        }

        return stones.length - numberOfComponents;
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
