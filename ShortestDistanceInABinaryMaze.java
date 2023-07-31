// https://practice.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1 and 
// https://leetcode.com/problems/shortest-path-in-binary-matrix/submissions/ (Can move in 8 directions so just add that logic)

import java.util.*;

/*
 * Use Dijkstras with queue and not PQ as all the distances are 1 so we don't need priority.
 */

public class ShortestDistanceInABinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{source[0], source[1], 0});
        int[] xDirections = {0, -1, 0, +1};
        int[] yDirections = {-1, 0, +1, 0};
        int[][] distance = new int[grid.length][grid[0].length];
        
        for(int[] i : distance)
        Arrays.fill(i, Integer.MAX_VALUE);
        
        distance[source[0]][source[1]] = 0;
        
        while(!queue.isEmpty())
        {
            int[] currentVertex = queue.remove();
            
            if(currentVertex[0] == destination[0] && currentVertex[1] == destination[1])
            return currentVertex[2];
            
            for(int i = 0; i < xDirections.length; i++)
            {
               int[] nVertex = new int[]{currentVertex[0] + xDirections[i], currentVertex[1] + yDirections[i], currentVertex[2] + 1};
               
               if(isSafe(nVertex[0], nVertex[1], grid) && nVertex[2] < distance[nVertex[0]][nVertex[1]])
               {
                   distance[nVertex[0]][nVertex[1]] = nVertex[2];
                   queue.add(nVertex);
               }
            }
        }
        
        return -1;
    }
    
    public boolean isSafe(int x, int y, int[][] grid)
    {
        return (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1);
    }
}
