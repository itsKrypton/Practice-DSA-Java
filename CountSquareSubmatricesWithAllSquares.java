// https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/

/*
 * Elements at first row and first column can never be a square of size more than one so keep them as it is. For the rest of the elements, check the minimum of their
 * previous row, col and diagonal for the minimum value because that's the number of squares it can form with the current element being the rightmost corner.
 */
public class CountSquareSubmatricesWithAllSquares {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        int totalSquares = 0;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(i == 0 || j == 0 || matrix[i][j] == 0)
                dp[i][j] = matrix[i][j];

                else
                dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));

                totalSquares += dp[i][j];
            }
        }

        return totalSquares;
    }
}
