// https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/

/*
 * Normally, we would want to choose the cell with the minimum distance having a value greater than 1 and we would do it via BFS but that approach would not work.
 * Thus, taking advantage of the smaller constraints, we can brute force it using backtracking by finding all the possible ways to make current 0 cell, a 1 cell by
 * choosing neighbor cells having more than 1 stones.
 */

public class MinimumMovesToSpreadStonesOverGrid {
    public int minimumMoves(int[][] grid) {
        // Base case, count total zeroes, if it's 0 then return 0 steps as the steps required to make every cell 0
        int totalZeroes = 0;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(grid[i][j] == 0)
                    totalZeroes++;
        
        if(totalZeroes == 0) return 0;
        
        // Go through all the current zeroes and run find the min steps to make it 1.
        int minSteps = Integer.MAX_VALUE;
        for(int currenti = 0; currenti < 3; currenti++)
            for(int currentj = 0; currentj < 3; currentj++)
                // If current cell is 0, find the cells using which we can make it 1.
                if(grid[currenti][currentj] == 0)
                {
                    for(int neighi = 0; neighi < 3; neighi++)
                        for(int neighj = 0; neighj < 3; neighj++)
                        {
                            //currentSteps are the steps required to make current cell 1 using neighbor cell.
                            int currentSteps = Math.abs(neighi - currenti) + Math.abs(neighj - currentj);
                            if(grid[neighi][neighj] > 1)
                            {
                                grid[neighi][neighj]--;
                                grid[currenti][currentj]++;
                                minSteps = Math.min(minSteps, currentSteps + minimumMoves(grid));
                                // Backtrack and find other neighbor cells using which we can make current cell 1.
                                grid[neighi][neighj]++;
                                grid[currenti][currentj]--;
                            }
                        }
                }
        
        return minSteps;
    }
}
