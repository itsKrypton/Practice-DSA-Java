import java.util.Arrays;

public class SudokuSolverLeet {

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, 
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, 
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        /* int[][] board = {
            {8, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0}, 
            {0, 7, 0, 0, 9, 0, 2, 0, 0}, 
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 4, 5, 7, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 3, 6},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0}
        }; */

        solveSudoku(board);

        for(char[] rows : board)
        System.out.println(Arrays.toString(rows));
    }

    public static void solveSudoku(char[][] board) {
        solver(board);
    }

    public static boolean solver(char[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == '.')
                {
                    for(char c = '1' ; c <= '9' ; c++)
                    {
                        if(isSafe(board, i, j, c))
                        {
                            board[i][j] = c;

                            if(solver(board))
                            return true;

                            else
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(char[][] board, int row, int col, char i) {
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
