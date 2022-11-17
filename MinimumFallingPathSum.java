// https://leetcode.com/problems/minimum-falling-path-sum/description/

//import java.util.Arrays;

public class MinimumFallingPathSum {
    // Memoization
    /* public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        
        for(int row[] : dp)
        Arrays.fill(row, -1);

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < matrix[0].length; i++)
        min = Math.min(min, findPaths(matrix, matrix.length - 1, i, dp));

        return min;
    }

    public static int findPaths(int[][] matrix, int currentX, int currentY, int[][] dp)
    {
        if(currentX == 0)
        return matrix[currentX][currentY];

        if(currentY < 0 || currentY > matrix[0].length - 1)
        return (int)Math.pow(10, 9);

        if(dp[currentX][currentY] != -1)
        return dp[currentX][currentY];

        int diagonalLeft = matrix[currentX][currentY] + findPaths(matrix, currentX - 1, currentY - 1, dp);
        int up = matrix[currentX][currentY] + findPaths(matrix, currentX - 1, currentY, dp);
        int diagonalRight = matrix[currentX][currentY] + findPaths(matrix, currentX - 1, currentY + 1, dp);

        return dp[currentX][currentY] = Math.min(diagonalLeft, Math.min(up, diagonalRight));
    } */

    // Tabulation
    /* public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        
        for(int row[] : dp)
        Arrays.fill(row, -1);

        return findPaths(matrix, dp);
    }

    public static int findPaths(int[][] matrix, int[][] dp)
    {
        for(int i = 0; i < matrix[0].length; i++)
        dp[0][i] = matrix[0][i];

        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                int diagonalLeft = (int)Math.pow(10, 9), up = (int)Math.pow(10, 9), diagonalRight = (int)Math.pow(10, 9);

                if(i > 0 && j > 0)
                diagonalLeft = matrix[i][j] + dp[i - 1][j - 1];

                if(i > 0)
                up = matrix[i][j] + dp[i - 1][j];

                if(i > 0 && j < matrix[0].length - 1)
                diagonalRight = matrix[i][j] + dp[i - 1][j + 1];

                dp[i][j] = Math.min(diagonalLeft, Math.min(up, diagonalRight));
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < matrix[0].length; i++)
        min = Math.min(min, dp[matrix.length - 1][i]);

        return min;
    } */

    // Space Optimized
    public int minFallingPathSum(int[][] matrix) {
        int[] prev = new int[matrix[0].length];

        for(int i = 0; i < matrix[0].length; i++)
        prev[i] = matrix[0][i];

        for(int i = 1; i < matrix.length; i++)
        {
            int[] temp = new int[prev.length];
            for(int j = 0; j < matrix[0].length; j++)
            {
                int diagonalLeft = (int)Math.pow(10, 9), up = (int)Math.pow(10, 9), diagonalRight = (int)Math.pow(10, 9);

                if(i > 0 && j > 0)
                diagonalLeft = matrix[i][j] + prev[j - 1];

                if(i > 0)
                up = matrix[i][j] + prev[j];

                if(i > 0 && j < matrix[0].length - 1)
                diagonalRight = matrix[i][j] + prev[j + 1];

                temp[j] = Math.min(diagonalLeft, Math.min(up, diagonalRight));
            }
            prev = temp;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < matrix[0].length; i++)
        min = Math.min(min, prev[i]);

        return min;
    }
}
