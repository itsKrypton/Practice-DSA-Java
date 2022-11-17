import java.util.Arrays;

public class CherryPickupII {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];

        for(int[][] i : dp)
        for(int[] j : i)
        Arrays.fill(j, -1);

        return findPaths(grid, 0, 0, grid[0].length - 1, dp);
    }

    public static int findPaths(int[][] grid, int currentX, int currentY1, int currentY2, int[][][] dp)
    {
        if(currentY1 < 0 || currentY1 > grid[0].length - 1 || currentY2 < 0 || currentY2 > grid[0].length - 1)
        return (int)Math.pow(-10, 9);

        if(currentX == grid.length - 1)
        {
            if(currentY1 == currentY2)
            return grid[currentX][currentY1];

            else
            return grid[currentX][currentY1] + grid[currentX][currentY2];
        }

        if(dp[currentX][currentY1][currentY2] != -1)
        return dp[currentX][currentY1][currentY2];

        int max = Integer.MIN_VALUE;
        for(int i = -1; i <= 1; i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                int ans = 0;

                if(i == j)
                ans = grid[currentX][currentY1] + findPaths(grid, currentX + 1, currentY1 + i, currentY2 + j, dp);

                else
                ans = grid[currentX][currentY1] + grid[currentX][currentY2] + findPaths(grid, currentX + 1, currentY1 + i, currentY2 + j, dp);

                max = Math.max(max, ans);
            }
        }

        return dp[currentX][currentY1][currentY2] = max;
    }
}
