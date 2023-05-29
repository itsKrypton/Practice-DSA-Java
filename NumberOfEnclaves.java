// https://leetcode.com/problems/number-of-enclaves/description/

/*
 * Same as SurroundedRegions
 */

public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] xDirections = {0, -1, 0, 1};
        int[] yDirections = {-1, 0, 1, 0};

        for(int j = 0; j < grid[0].length; j++)
        {
            // First row
            if(grid[0][j] == 1 && !visited[0][j])
            dfs(new Pair(0, j), grid, visited, xDirections, yDirections);

            // Last row
            if(grid[grid.length - 1][j] == 1 && !visited[grid.length - 1][j])
            dfs(new Pair(grid.length - 1, j), grid, visited, xDirections, yDirections);
        }

        for(int i = 0; i < grid.length; i++)
        {
            // First col
            if(grid[i][0] == 1 && !visited[i][0])
            dfs(new Pair(i, 0), grid, visited, xDirections, yDirections);

            // Last col
            if(grid[i][grid[0].length - 1] == 1 && !visited[i][grid[0].length - 1])
            dfs(new Pair(i, grid[0].length - 1), grid, visited, xDirections, yDirections);
        }

        int count = 0;
        for(int i = 1; i < grid.length - 1; i++)
        {
            for(int j = 1; j < grid[0].length - 1; j++)
            {
                if(grid[i][j] == 1 && !visited[i][j]) count++;
            }
        }

        return count;
    }

    public void dfs(Pair currentVertex, int[][] grid, boolean[][] visited, int[] xDirections, int[] yDirections)
    {
        visited[currentVertex.x][currentVertex.y] = true;

        for(int i = 0; i < xDirections.length; i++)
        {
            Pair nVertex = new Pair(currentVertex.x + xDirections[i], currentVertex.y + yDirections[i]);

            if(isValid(nVertex, grid) && grid[nVertex.x][nVertex.y] == 1 && !visited[nVertex.x][nVertex.y])
            dfs(nVertex, grid, visited, xDirections, yDirections);
        }
    }

    public boolean isValid(Pair position, int[][] grid)
    {
        return (position.x >= 0 && position.y >= 0 && position.x < grid.length && position.y < grid[position.x].length);
    }

    public class Pair {
        private int x;
        private int y;

        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
