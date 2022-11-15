//import java.util.Arrays;

public class UniquePaths {
    /* public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        
        for(int row[] : dp)
        Arrays.fill(row, -1);

        return findPaths(m - 1, n - 1, dp);
    }     */

    //Memoization
    /* public static int findPaths(int currentX, int currentY, int[][] dp)
    {
        if(currentX == 0 && currentY == 0)
        return 1;

        else if(currentX < 0 || currentY < 0)
        return 0;

        else if(dp[currentX][currentY] != -1)
        return dp[currentX][currentY];
        
        int up = 0, left = 0;
        up += findPaths(currentX, currentY - 1, dp);
        left += findPaths(currentX - 1, currentY, dp);

        return dp[currentX][currentY] = up + left;
    } */

    //Tabulation
    /* public static int findPaths(int currentX, int currentY, int[][] dp)
    {
        dp[0][0] = 1;

        for(int i = 0; i <= currentX; i++)
        {
            for(int j = 0; j <= currentY; j++)
            {
                if(!(i == 0 && j == 0))
                {
                    int up = 0, left = 0;

                    if(j > 0)
                    left = dp[i][j-1];

                    if(i > 0)
                    up = dp[i-1][j];

                    dp[i][j] = up + left;
                }
            }
        }
        
        return dp[currentX][currentY];
    } */

    //Space optimized
    public static int uniquePaths(int m, int n) {
        int prev[] = new int[n];

        for(int i = 0; i < m; i++)
        {
            int[] temp = new int[n];
            temp[0] = 1;
            for(int j = 0; j < n; j++)
            {
                if(!(i == 0 && j == 0))
                {
                    int up = 0, left = 0;

                    if(j > 0)
                    left = temp[j-1];

                    if(i > 0)
                    up = prev[j];

                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        
        return prev[n-1];
    }    
}
