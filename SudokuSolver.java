import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        /* int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0}, 
            {0, 9, 8, 0, 0, 0, 0, 6, 0}, 
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        }; */

        int[][] board = {
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0}, 
            {0, 7, 0, 0, 9, 0, 2, 0, 0}, 
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 4, 5, 7, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };

        solve(board, 0, 0);
    }

    public static void solve(int[][] board, int row, int col)
    {
        if(row == board.length && col == 0)
        {
            for(int i[] : board)
            System.out.println(Arrays.toString(i));
            return;
        }
        
        if(col == board.length)
        {
            solve(board, row + 1, 0);
            return;
        }

        if(board[row][col] == 0)
        {
            for(int i = 1; i <= 9; i++)
            {
                if(isSafe(board, row, col, i))
                {
                    board[row][col] = i;
                    solve(board, row, col + 1);
                    board[row][col] = 0;
                }

                /* else
                continue; */
            }
        }

        else
        solve(board, row, col + 1);
    }

    private static boolean isSafe(int[][] board, int row, int col, int i) 
    {
        for(int j = 0; j < board.length; j++)
        {
            if(board[row][j] == i)
            return false;
        }

        for(int j = 0; j < board.length; j++)
        {
            if(board[j][col] == i)
            return false;
        }

        for(int j = (row - (row % 3)); j < ((row - (row % 3)) + 3); j++)
        {
            for(int k = (col - (col % 3)); k < ((col - (col % 3)) + 3); k++)
            {
                if(board[j][k] == i)
                return false;
            }
        }

        return true;
    }
}
