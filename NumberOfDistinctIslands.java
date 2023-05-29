// https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1

/*
 * We basically need to store the shape of every island and maintain a set of those shapes to see whether that shape already exists in the set or not. We can do this
 * by storing the starting node and storing nVertex - startingNode cords for every traversal that we do. This will always be the same if we find another similar
 * island. In that case, the set won't allow it to be added and at the end we just return the set's size. We are storing an ArrayList of strings inside the hashset
 * to mark the shape and check for equality.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfDistinctIslands {
    int countDistinctIslands(int[][] grid) {
        HashSet<ArrayList<String>> set = new HashSet<>();
        int[] xDirections = {0, -1, 0, 1};
        int[] yDirections = {-1, 0, 1, 0};
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 1 && !visited[i][j])
                set.add(bfs(new Pair(i, j), grid, visited, xDirections, yDirections));
            }
        }

        return set.size();
    }

    public ArrayList<String> bfs(Pair startingVertex, int[][] grid, boolean[][] visited, int[] xDirections, int[] yDirections)
    {
        ArrayList<String> shape = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(startingVertex);
        visited[startingVertex.x][startingVertex.y] = true;
        shape.add("0, 0");

        while(!queue.isEmpty())
        {
            Pair currentVertex = queue.remove();

            for(int i = 0; i < xDirections.length; i++)
            {
                Pair nVertex = new Pair(currentVertex.x + xDirections[i], currentVertex.y + yDirections[i]);

                if(isValid(nVertex, grid) && grid[nVertex.x][nVertex.y] == 1 && !visited[nVertex.x][nVertex.y])
                {
                    queue.add(nVertex);
                    visited[nVertex.x][nVertex.y] = true;
                    shape.add((new Pair(nVertex.x - startingVertex.x, nVertex.y - startingVertex.y)).toString());
                }
            }
        }

        return shape;
    }

    public boolean isValid(Pair position, int[][] grid)
    {
        return (position.x >= 0 && position.y >= 0 && position.x < grid.length && position.y < grid[position.x].length);
    }

    public class Pair {
        private int x;
        private int y;

        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return Integer.toString(x) + ", " + Integer.toString(y);
        }
    }
}
