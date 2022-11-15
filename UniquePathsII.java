//https://leetcode.com/problems/unique-paths-ii/description/

//import java.util.Arrays;

public class UniquePathsII {
    /* public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for(int row[] : dp)
        Arrays.fill(row, -1);

        return findPaths(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, dp);
    } */

    //Memoization
    /* public static int findPaths(int[][] obstacleGrid, int currentX, int currentY, int[][] dp)
    {
        if(currentX == 0 && currentY == 0 && obstacleGrid[currentX][currentY] == 0)
        return 1;

        else if(currentX < 0 || currentY < 0 || obstacleGrid[currentX][currentY] == 1)
        return 0;

        else if(dp[currentX][currentY] != -1)
        return dp[currentX][currentY];

        int up = 0, left = 0;
        up += findPaths(obstacleGrid, currentX, currentY - 1, dp);
        left += findPaths(obstacleGrid, currentX - 1, currentY, dp);

        return dp[currentX][currentY] = up + left;
    } */

    //Tabulation
    /* public static int findPaths(int[][] obstacleGrid, int currentX, int currentY, int[][] dp)
    {
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for(int i = 0; i <= currentX; i++)
        {
            for(int j = 0; j <= currentY; j++)
            {
                if(!(i == 0 && j == 0))
                {
                    int up = 0, left = 0;

                    if(j > 0 && obstacleGrid[i][j] == 0)
                    left = dp[i][j-1];

                    if(i > 0 && obstacleGrid[i][j] == 0)
                    up = dp[i-1][j];

                    dp[i][j] = up + left;
                }
            }
        }
        
        return dp[currentX][currentY];
    } */

    //Space Optimized
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int prev[] = new int[obstacleGrid[0].length];

        for(int i = 0; i < obstacleGrid.length; i++)
        {
            int[] temp = new int[obstacleGrid[0].length];
            temp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
            for(int j = 0; j < obstacleGrid[0].length; j++)
            {
                if(!(i == 0 && j == 0))
                {
                    int up = 0, left = 0;

                    if(j > 0 && obstacleGrid[i][j] == 0)
                    left = temp[j-1];

                    if(i > 0 && obstacleGrid[i][j] == 0)
                    up = prev[j];

                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        
        return prev[obstacleGrid[0].length-1];
    }
}
