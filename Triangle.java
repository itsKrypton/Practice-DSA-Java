// https://leetcode.com/problems/triangle/description/

//import java.util.Arrays;
import java.util.List;

public class Triangle {

    //Memoization
    /* public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        
        for(int row[] : dp)
        Arrays.fill(row, -1);

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < triangle.get(triangle.size() - 1).size(); i++)
        min = Math.min(min, findPaths(triangle, triangle.size() - 1, i, dp));

        return min;
    } */

    /* public static int findPaths(List<List<Integer>> triangle, int currentX, int currentY, int[][] dp)
    {
        if(currentX == 0 && currentY == 0)
        return triangle.get(currentX).get(currentY);

        if(currentX < 0 || currentY < 0 || currentY > triangle.get(currentX).size() - 1)
        return (int)Math.pow(10, 9);

        if(dp[currentX][currentY] != -1)
        return dp[currentX][currentY];

        int up = triangle.get(currentX).get(currentY) + findPaths(triangle, currentX - 1, currentY, dp);
        int upLeft = triangle.get(currentX).get(currentY) + findPaths(triangle, currentX - 1, currentY - 1, dp);

        return dp[currentX][currentY] = Math.min(up, upLeft);
    } */

    // Tabulation
    /* public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        
        for(int row[] : dp)
        Arrays.fill(row, -1);

        return findPaths(triangle, dp);
    }

    public static int findPaths(List<List<Integer>> triangle, int[][] dp)
    {
        dp[0][0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= triangle.size() - 1; i++)
        {
            for(int j = 0; j <= triangle.get(i).size() - 1; j++)
            {
                if(!(i == 0 && j == 0))
                {
                    int up = (int)Math.pow(10,9), upLeft = (int)Math.pow(10,9);

                    if(i > 0 && j < triangle.get(i).size() - 1)
                    up = triangle.get(i).get(j) + dp[i - 1][j];

                    if(i > 0 && j > 0)
                    upLeft = triangle.get(i).get(j) + dp[i - 1][j - 1];

                    dp[i][j] = Math.min(up, upLeft);
                }

                if(i == triangle.size() - 1)
                min = Math.min(min, dp[i][j]);
            }
        }

        return min;
    } */

    //Space optimization
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.get(triangle.size() - 1).size() == 1)
        return triangle.get(0).get(0);

        int[] prev = new int[triangle.get(triangle.size() - 1).size()];

        int min = Integer.MAX_VALUE;

        for(int i = 0; i <= triangle.size() - 1; i++)
        {
            int temp[] = new int[prev.length];
            temp[0] = triangle.get(0).get(0);
            
            for(int j = 0; j <= triangle.get(i).size() - 1; j++)
            {
                if(!(i == 0 && j == 0))
                {
                    int up = (int)Math.pow(10,9), upLeft = (int)Math.pow(10,9);

                    if(i > 0 && j < triangle.get(i).size() - 1)
                    up = triangle.get(i).get(j) + prev[j];

                    if(i > 0 && j > 0)
                    upLeft = triangle.get(i).get(j) + prev[j - 1];

                    temp[j] = Math.min(up, upLeft);
                }

                if(i == triangle.size() - 1)
                min = Math.min(min, temp[j]);
            }
            prev = temp;
        }

        return min;
    }
}
