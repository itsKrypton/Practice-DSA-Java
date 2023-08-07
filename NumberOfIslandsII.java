// https://practice.geeksforgeeks.org/problems/number-of-islands/1

import java.util.*;

/*
 * Using a ds of rows * cols length, treat individual cells of the matrix as graph nodes. For island added, increment the current islands and if there exists neighbours,
 * then do a union of current and neighbour nodes if there ultimate parents are different and decrement the current islands.
 */

public class NumberOfIslandsII {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet ds = new DisjointSet(rows * cols);
        int[] xDirections = new int[]{0, -1, 0, +1};
        int[] yDirections = new int[]{-1, 0, +1, 0};
        int[][] board = new int[rows][cols];
        List<Integer> islands = new ArrayList<>();
        int currentIslands = 0;
        
        for(int[] operator : operators)
        {
            if(board[operator[0]][operator[1]] == 1)
            {
                islands.add(currentIslands);
                continue;
            }
            
            board[operator[0]][operator[1]] = 1;
            currentIslands++;
            
            for(int i = 0; i < xDirections.length; i++)
            {
                int neighborX = operator[0] + xDirections[i];
                int neighborY = operator[1] + yDirections[i];
                int currentVertex = (operator[0] * cols) + operator[1];
                int nVertex = (neighborX * cols) + neighborY;
                
                if(isSafe(neighborX, neighborY, board) && ds.findParent(currentVertex) != ds.findParent(nVertex))
                {
                    ds.unionBySize(nVertex, currentVertex);
                    currentIslands--;
                }
            }
            
            islands.add(currentIslands);
        }
        
        return islands;
    }
    
    public boolean isSafe(int x, int y, int[][] board)
    {
        return (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 1);
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
