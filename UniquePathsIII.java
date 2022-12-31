// https://leetcode.com/problems/unique-paths-iii/description/

public class UniquePathsIII {
    /* 
        It is basically the same problem as find all paths from starting point to ending point with obstacles but we also need to make sure that all valid squares
        are visited. When we are finding the starting square, we will also count all the valid squares that can be visited including the starting square, we will 
        call that totalZeroes. Now, along with marking the current square as -1 when moving to another square, we will also decrease the number of totalZeroes. When
        we reach the destination, we will add one more condition to check if the totalZeroes is zero (i.e all the valid squares were visited, else we don't count that
        path).
    */ 
    public int uniquePathsIII(int[][] grid) {
        int[] startAndZeroes = new int[3];
        findStartAndZeroes(grid, startAndZeroes);

        return find(startAndZeroes[0], startAndZeroes[1], startAndZeroes[2], grid);
    }

    // Backtracking and DFS
    public static int find(int currentX, int currentY, int totalZeroes, int[][] grid)
    {
        if(grid[currentX][currentY] == -1)
        return 0;

        if(grid[currentX][currentY] == 2)
        return (totalZeroes == 0) ? 1 : 0;

        grid[currentX][currentY] = -1; // We are taking this path.
        totalZeroes--; // Decreasing the number of visited squares

        int right = 0, down = 0, left = 0, up = 0;

        if(isInsideGrid(currentX + 1, currentY, grid))
        right += find(currentX + 1, currentY, totalZeroes, grid);

        if(isInsideGrid(currentX, currentY + 1, grid))
        down += find(currentX, currentY + 1, totalZeroes, grid);

        if(isInsideGrid(currentX - 1, currentY, grid))
        left += find(currentX - 1, currentY, totalZeroes, grid);

        if(isInsideGrid(currentX, currentY - 1, grid))
        up += find(currentX, currentY - 1, totalZeroes, grid);

        grid[currentX][currentY] = 0;
        totalZeroes++;

        return right + down + left + up;
    }

    public static boolean isInsideGrid(int currentX, int currentY, int[][] grid)
    {
        return (currentX >= 0 && currentX < grid.length && currentY >= 0 && currentY < grid[0].length);
    }

    public static void findStartAndZeroes(int[][] grid, int[] startAndZeroes)
    {
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    startAndZeroes[0] = i;
                    startAndZeroes[1] = j;
                    startAndZeroes[2]++;
                }

                if(grid[i][j] == 0)
                startAndZeroes[2]++;
            }
        }
    }
}
