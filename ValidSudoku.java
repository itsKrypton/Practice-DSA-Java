import java.util.HashMap;
import java.util.HashSet;

/*
 * Two ways to do it, you can either store row/col/grid number along with the current number as string in hashset or have three hashmaps for rows, cols, and grids
 * and add the current number in all of them.
 */

public class ValidSudoku {
    /* public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] != '.')
                {
                    if(!(set.add(i + "r" + board[i][j]) && set.add(j + "c" + board[i][j]) && set.add((i / 3) + "r" + (j / 3) + "c" + board[i][j])))
                    return false;
                }
            }
        }

        return true;
    } */

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<Integer, HashSet<Character>> grids = new HashMap<>();

        for(int i = 0; i < 9; i++)
        {
            rows.put(i, new HashSet<Character>());
            cols.put(i, new HashSet<Character>());
            grids.put(i, new HashSet<Character>());
        }

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] != '.')
                {
                    if(!isSafe(i, j, board, rows, cols, grids))
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isSafe(int i, int j, char[][] board, HashMap<Integer, HashSet<Character>> rows, HashMap<Integer, HashSet<Character>> cols, HashMap<Integer, HashSet<Character>> grids)
    {
        int gridNumber = (3 * (i / 3)) + (j / 3);
        return (rows.get(i).add(board[i][j]) && cols.get(j).add(board[i][j]) && grids.get(gridNumber).add(board[i][j]));
    }
}
