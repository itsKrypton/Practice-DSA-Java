// https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

/*
 * Multiple source shortest path algorithm. Create a distance array with same values as input the only difference being that if a edge doesn't exist then set it as 1e9.
 * Now we need to find distances between two nodes through all the nodes one by one. Thus we will have three loops, outer loop signifying which node we are finding the
 * route from and other two loops to mark the current row and column. Then simply set the distance as minimum of current distance and current node to set node + set node
 * to neighbor node.
 * 
 * To find negative cycle, just check diagonal values. if they're negative then there is a negative cycle.
 * 
 * T: O(v^3)
 */

public class FloydWarshall {
    public void shortest_distance(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            // Set the initial distance matrix
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(i == j)
                continue;
                
                if(matrix[i][j] == -1)
                matrix[i][j] = (int)(1e9);
            }
        }
        
        // Update each node V times.
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix.length; j++)
            {
                for(int k = 0; k < matrix[0].length; k++)
                matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
            }
        }
        
        // Setting 1e9 nodes to -1 again.
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == (int)(1e9))
                matrix[i][j] = -1;
            }
        }
    }
}
