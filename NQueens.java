public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(nQueens(board, 0));
    }

    public static int nQueens(boolean[][] board, int row)
    {
        //This is the base condition where all the queens are placed and now we need to return the count and display the board
        if(row == board.length)
        {
            display(board);
            System.out.println();
            return 1;
        }

        //Now we start placing the queens
        int count = 0;
        for(int col = 0; col < board.length; col++)
        {
            //check if the current position is safe to place the queen, if it is then place it and check for the next row.
            if(isSafe(board, row, col))
            {
                board[row][col] = true;
                count += nQueens(board, row+1);
                board[row][col] = false;
            }
        }

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) 
    {
        //checks for the rows above the queen is same col
        for(int i = 0; i < row; i++)
        {
            if(board[i][col])
            return false;
        }

        //checks for diagonals to the left
        for(int i = 1; row-i>=0 && col-i>=0; i++)
        {
            if(board[row-i][col-i])
            return false;
        }

        //checks for diagonals to the right
        for(int i = 1; row-i>=0 && col+i<=board.length-1; i++)
        {
            if(board[row-i][col+i])
            return false;
        }

        return true;
    }

    public static void display(boolean[][] board)
    {
        for(boolean[] rows : board)
        {
            for(boolean element : rows)
            {
                if(element)
                System.out.print("Q ");

                else
                System.out.print("X ");
            }
            System.out.println();
        }
    }
}
