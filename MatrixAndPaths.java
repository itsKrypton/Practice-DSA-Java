import java.util.Arrays;

public class MatrixAndPaths {
    public static void main(String[] args) {
        /* int maze[][] = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        }; */

        boolean maze[][] = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };

        int path[][] = new int[maze.length][maze[0].length];

        /* solve("", maze, 0, 0, 1); */
        solve2("", maze, path, 0, 0, 1);
    }

    // Here we are using backtracking to print the path of reaching the end

    //If int matrix is given as input
    public static void solve(String pString, int[][] maze, int row, int col, int step)
    {
        if(row == maze.length - 1 && col == maze[0].length - 1)
        {
            maze[row][col] = step;
            for(int[] i : maze)
            System.out.println(Arrays.toString(i));
            
            System.out.println(pString);
            System.out.println();
            return;
        }

        if(maze[row][col] != 0)
        return;

        //Considering this path
        maze[row][col] = step;

        if(row < maze.length - 1)
        solve(pString + "D", maze, row + 1, col, step + 1);

        if(col < maze[0].length - 1)
        solve(pString + "R", maze, row, col + 1, step + 1);

        if(row > 0)
        solve(pString + "U", maze, row - 1, col, step + 1);

        if(col > 0)
        solve(pString + "L", maze, row, col - 1, step + 1);

        maze[row][col] = 0;
    }

    //If boolean matrix is given as input
    public static void solve2(String pString, boolean[][] maze, int[][] path, int row, int col, int step)
    {
        if(row == maze.length - 1 && col == maze[0].length - 1)
        {
            path[row][col] = step;
            for(int[] i : path)
            System.out.println(Arrays.toString(i));
            
            System.out.println(pString);
            System.out.println();
            return;
        }

        if(!maze[row][col])
        return;

        //Considering this path
        path[row][col] = step;
        maze[row][col] = false;

        if(row < maze.length - 1)
        solve2(pString + "D", maze, path, row + 1, col, step + 1);

        if(col < maze[0].length - 1)
        solve2(pString + "R", maze, path, row, col + 1, step + 1);

        if(row > 0)
        solve2(pString + "U", maze, path, row - 1, col, step + 1);

        if(col > 0)
        solve2(pString + "L", maze, path, row, col - 1, step + 1);

        path[row][col] = 0;
        maze[row][col] = true;
    }
}
