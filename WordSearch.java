//https://leetcode.com/problems/word-search/submissions/

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
            {'A'}
        };

        System.out.println(exist(board, "A"));
    }
    
    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(word.length() == 1)
                    return true;

                    if(find(board, word, i, j))
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean find(char[][] board, String uString, int row, int col)
    {
        if(uString.isEmpty())
        return true;

        if(board[row][col] == '0')
        return false;

        char ch = uString.charAt(0);

        //considering this step
        char temp = board[row][col];
        boolean down = false, right = false, up = false, left = false;

        if(board[row][col] == ch)
        {
            board[row][col] = '0';
            //down
            if(row < board.length - 1)
            down = find(board, uString.substring(1), row + 1, col);

            //right
            if(col < board[0].length - 1)
            right = find(board, uString.substring(1), row, col + 1);

            //up
            if(row > 0)
            up = find(board, uString.substring(1), row - 1, col);

            //left
            if(col > 0)
            left = find(board, uString.substring(1), row, col - 1);

            board[row][col] = temp;
        }

        else
        return false;

        return (down || right || up || left);
    }
}
