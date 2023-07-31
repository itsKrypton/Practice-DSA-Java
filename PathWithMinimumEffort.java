// https://leetcode.com/problems/path-with-minimum-effort/description/ and https://practice.geeksforgeeks.org/problems/path-with-minimum-effort/1

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Solve using Dijkstra's. For every neighbor vertex we find the new effort and check if it's less than the current neighbor effort, 
 * then we update the effort and add it to queue.
 */

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        queue.add(new int[]{0, 0, 0});
        int[] xDirections = {0, -1, 0, +1};
        int[] yDirections = {-1, 0, +1, 0};
        int[][] effort = new int[heights.length][heights[0].length];
        
        for(int[] i : effort)
        Arrays.fill(i, Integer.MAX_VALUE);
        
        effort[0][0] = 0;
        
        while(!queue.isEmpty())
        {
            int[] currentVertex = queue.remove();
            
            for(int i = 0; i < xDirections.length; i++)
            {
                int newRow = currentVertex[0] + xDirections[i];
                int newCol = currentVertex[1] + yDirections[i];
               
               if(isSafe(newRow, newCol, heights))
               {
                   int absDiff = Math.abs(heights[newRow][newCol] - heights[currentVertex[0]][currentVertex[1]]);
                   int newEffort = Math.max(absDiff, effort[currentVertex[0]][currentVertex[1]]);

                   if(newEffort < effort[newRow][newCol])
                   {
                        effort[newRow][newCol] = newEffort;
                        queue.add(new int[]{newRow, newCol, newEffort});
                   }
               }
            }
        }
        
        return effort[heights.length - 1][heights[0].length - 1];
    }

    public boolean isSafe(int x, int y, int[][] grid)
    {
        return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length);
    }
}
