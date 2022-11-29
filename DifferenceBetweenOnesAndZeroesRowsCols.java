// https://leetcode.com/contest/biweekly-contest-92/problems/difference-between-ones-and-zeros-in-row-and-column/

public class DifferenceBetweenOnesAndZeroesRowsCols {
    public int[][] onesMinusZeros(int[][] grid) {
        int[][] answer = new int[grid.length][grid[0].length];
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    rows[i]++;
                    cols[j]++;
                }

                else
                {
                    rows[i]--;
                    cols[j]--;
                }
            }
        }

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            answer[i][j] = rows[i] + cols[j];
        }

        return answer;
    }
}
