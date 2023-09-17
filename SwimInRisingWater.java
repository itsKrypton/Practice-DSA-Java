// https://leetcode.com/problems/swim-in-rising-water/description/

//import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Using Dijkstra's algorithm to find the path with the min time to reach the end
 */

public class SwimInRisingWater {
    // Keeping a track of timeToReach throughout the route in an array.
    /* public static int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]]));
        int[] xDirections = {0, -1, 0, 1};
        int[] yDirections = {-1, 0, 1, 0};
        int[][] timeToReach = new int[grid.length][grid[0].length];

        for(int[] i : timeToReach)
            Arrays.fill(i, Integer.MAX_VALUE);

        pq.add(new int[]{0, 0});
        timeToReach[0][0] = 0;
        while(!pq.isEmpty())
        {
            int[] currentVertex = pq.remove();

            for(int i = 0; i < 4; i++)
            {
                int newRow = currentVertex[0] + xDirections[i];
                int newCol = currentVertex[1] + yDirections[i];

                if(isSafe(newRow, newCol, grid))
                {
                    int newTime = Math.max(grid[newRow][newCol], timeToReach[currentVertex[0]][currentVertex[1]]);

                    if(newTime < timeToReach[newRow][newCol])
                    {
                        timeToReach[newRow][newCol] = newTime;
                        pq.add(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return timeToReach[grid.length - 1][grid[0].length - 1];
    } */

    // Using a single variable for timeTaken but using a visited array
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(grid[a[0]][a[1]], grid[b[0]][b[1]]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] xDirections = {0, -1, 0, 1};
        int[] yDirections = {-1, 0, 1, 0};

        pq.add(new int[]{0, 0});
        int timeTaken = 0;
        visited[0][0] = true;
        while(!pq.isEmpty())
        {
            int[] currentVertex = pq.remove();
            timeTaken = Math.max(timeTaken, grid[currentVertex[0]][currentVertex[1]]);

            if(currentVertex[0] == grid.length - 1 && currentVertex[1] == grid[0].length - 1)
            return timeTaken;

            for(int i = 0; i < 4; i++)
            {
                int newRow = currentVertex[0] + xDirections[i];
                int newCol = currentVertex[1] + yDirections[i];

                if(isSafe(newRow, newCol, grid) && !visited[newRow][newCol])
                {
                    pq.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return 0;
    }

    public static boolean isSafe(int row, int col, int[][] grid)
    {
        return (row > 0 && row < grid.length && col > 0 && col < grid[0].length);
    }
}
