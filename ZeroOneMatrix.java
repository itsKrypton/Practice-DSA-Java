// https://leetcode.com/problems/01-matrix/description/

/* 
 * We need to find the distance of nearest 0's so we basically start BFS from all 0's to find the distance of all the 1's level wise (which will give us the nearest
 * distance as BFS searches the nearest neighbors first).
 */

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    // Using output array as visited array as well
    public int[][] updateMatrix(int[][] mat) {
        int[][] output = new int[mat.length][mat[0].length];
        Queue<Group> queue = new LinkedList<>();
        int[] xDirections = {0, -1, 0, 1};
        int[] yDirections = {-1, 0, 1, 0};

        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[0].length; j++)
            {
                if(mat[i][j] == 0)
                queue.add(new Group(i, j, 0));
                
                else
                output[i][j] = -1;
            }
        }

        while(!queue.isEmpty())
        {
            Group currentVertex = queue.remove();
            output[currentVertex.x][currentVertex.y] = currentVertex.distance;

            for(int i = 0; i < xDirections.length; i++)
            {
                Group nVertex = new Group(currentVertex.x + xDirections[i], currentVertex.y + yDirections[i], currentVertex.distance + 1);

                if(isValid(nVertex, mat) && output[nVertex.x][nVertex.y] == -1)
                {
                    queue.add(nVertex);
                    output[nVertex.x][nVertex.y] = 1; // We are just marking it with a non -1 value to tell that it's already visited.
                }
            }
        }

        return output;
    }

    /* public int[][] updateMatrix(int[][] mat) {
        int[][] output = new int[mat.length][mat[0].length];
        int[][] visited = new int[mat.length][mat[0].length];
        Queue<Group> queue = new LinkedList<>();
        int[] xDirections = {0, -1, 0, 1};
        int[] yDirections = {-1, 0, 1, 0};

        for(int i = 0; i < mat.length; i++)
        {
            for(int j = 0; j < mat[0].length; j++)
            {
                if(mat[i][j] == 0)
                {
                    queue.add(new Group(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        while(!queue.isEmpty())
        {
            Group currentVertex = queue.remove();
            output[currentVertex.x][currentVertex.y] = currentVertex.distance;

            for(int i = 0; i < xDirections.length; i++)
            {
                Group nVertex = new Group(currentVertex.x + xDirections[i], currentVertex.y + yDirections[i], currentVertex.distance + 1);

                if(isValid(nVertex, mat) && visited[nVertex.x][nVertex.y] == 0)
                {
                    queue.add(nVertex);
                    visited[nVertex.x][nVertex.y] = 1;
                }
            }
        }

        return output;
    } */

    public boolean isValid(Group position, int[][] mat)
    {
        return (position.x >= 0 && position.y >= 0 && position.x < mat.length && position.y < mat[position.x].length);
    }

    public class Group {
        private int x;
        private int y;
        private int distance;

        public Group(int x, int y, int distance)
        {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
