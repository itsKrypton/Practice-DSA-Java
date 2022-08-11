public class NKnights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        System.out.println(nKnights(board, 0, 0, n));
    }

    public static int nKnights(boolean board[][], int row, int col, int targets)
    {
        //If all knights are placed, print it and return 1
        if(targets == 0)
        {
            display(board);
            System.out.println();
            return 1;
        }

        //If we have reached the end of the board, return
        if(row == board.length - 1 && col == board.length)
        return 0;

        int count = 0;

        //If we reach the last column, start from the first col in the next row
        if(col == board.length)
        {
            count += nKnights(board, row + 1, 0, targets);
            return count;
        }

        //Check if the position is safe and place the knight accordingly
        if(isSafe(board, row, col))
        {
            board[row][col] = true;
            count += nKnights(board, row, col + 1, targets - 1);
            board[row][col] = false;
        }

        count += nKnights(board, row, col + 1, targets);

        return count;
    }

    public static boolean isSafe(boolean[][] board, int row, int col) 
    {
        if(isValid(board, row - 1, col - 2) && board[row - 1][col - 2])
        return false;

        if(isValid(board, row - 1, col + 2) && board[row - 1][col + 2])
        return false;

        if(isValid(board, row - 2, col - 1) && board[row - 2][col - 1])
        return false;

        if(isValid(board, row - 2, col + 1) && board[row - 2][col + 1])
        return false;

        return true;
    }

    public static boolean isValid(boolean[][] board, int row, int col)
    {
        if(row >= 0 && row < board.length && col >=0 && col < board[row].length)
        return true;

        return false;
    }

    public static void display(boolean[][] board) 
    {
        for(boolean[] rows : board)
        {
            for(boolean element : rows)
            {
                if(element)
                System.out.print("K ");

                else
                System.out.print("X ");
            }
            System.out.println();
        }
    }
}
