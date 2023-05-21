// https://leetcode.com/problems/rotting-oranges/description/

/*
 * It says minimum time to rot all oranges which is basically BFS as we are going level wise. Count all the current fresh oranges and this time use a Group DS to also
 * store the time when the oranges were rotten. All the neighboring oranges of the current orange will be rotten at the time of current orange + 1. Keep a track of the
 * max time to rot the oranges and at the end if any fresh orange is left then return -1 else return the max time to rot all the oranges.
 */

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<Group> queue = new LinkedList<>();
        int[] xDirections = {0, -1, 0, 1};
        int[] yDirections = {-1, 0, 1, 0};
        int freshOranges = 0;

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 2)
                {
                    visited[i][j] = 2;
                    queue.add(new Group(i, j, 0));
                }

                else 
                visited[i][j] = 0;

                if(grid[i][j] == 1) freshOranges++;
            }
        }

        int maxTime = 0;
        while(!queue.isEmpty())
        {
            Group currentVertex = queue.remove();

            for(int i = 0; i < xDirections.length; i++)
            {
                Group nVertex = new Group(currentVertex.x + xDirections[i], currentVertex.y + yDirections[i], currentVertex.time + 1);

                if(isValid(nVertex, grid) && grid[nVertex.x][nVertex.y] == 1 && visited[nVertex.x][nVertex.y] != 2)
                {
                    visited[nVertex.x][nVertex.y] = 2;
                    freshOranges--;
                    maxTime = Math.max(maxTime, nVertex.time);
                    queue.add(nVertex);
                }
            }
        }

        return (freshOranges == 0) ? maxTime : -1;
    }

    public boolean isValid(Group position, int[][] grid)
    {
        return (position.x >= 0 && position.y >= 0 && position.x < grid.length && position.y < grid[position.x].length);
    }

    public class Group {
        private int x;
        private int y;
        private int time;
        
        public Group(int x, int y, int time)
        {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
