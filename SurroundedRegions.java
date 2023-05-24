// https://leetcode.com/problems/surrounded-regions/description/

/*
 * The problem states that you need to flip a group of O's which are all surrounded by X's. Even if one of them is at the border then the entire group cannot be flipped.
 * Thus, we just loop at the edges and find the O's. Then we start a DFS from that O to check all the O's that are connected to it as those won't be flipped. At the end,
 * all the O's that are not yet visited can be flipped as it would only be visited if there was a connection from that O to an O at the border. See example to understand.
 */

public class SurroundedRegions {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[] xDirections = {0, -1, 0, 1};
        int[] yDirections = {-1, 0, 1, 0};

        for(int j = 0; j < board[0].length; j++)
        {
            // First row
            if(board[0][j] == 'O' && !visited[0][j])
            dfs(new Pair(0, j), board, visited, xDirections, yDirections);

            // Last row
            if(board[board.length - 1][j] == 'O' && !visited[board.length - 1][j])
            dfs(new Pair(board.length - 1, j), board, visited, xDirections, yDirections);
        }

        for(int i = 0; i < board.length; i++)
        {
            // First col
            if(board[i][0] == 'O' && !visited[i][0])
            dfs(new Pair(i, 0), board, visited, xDirections, yDirections);

            // Last col
            if(board[i][board[0].length - 1] == 'O' && !visited[i][board[0].length - 1])
            dfs(new Pair(i, board[0].length - 1), board, visited, xDirections, yDirections);
        }

        for(int i = 1; i < board.length - 1; i++)
        {
            for(int j = 1; j < board[0].length - 1; j++)
            {
                if(board[i][j] == 'O' && !visited[i][j])
                board[i][j] = 'X';
            }
        }
    }

    public void dfs(Pair currentVertex, char[][] board, boolean[][] visited, int[] xDirections, int[] yDirections)
    {
        visited[currentVertex.x][currentVertex.y] = true;

        for(int i = 0; i < xDirections.length; i++)
        {
            Pair nVertex = new Pair(currentVertex.x + xDirections[i], currentVertex.y + yDirections[i]);

            if(isValid(nVertex, board) && board[nVertex.x][nVertex.y] == 'O' && !visited[nVertex.x][nVertex.y])
            dfs(nVertex, board, visited, xDirections, yDirections);
        }
    }

    public boolean isValid(Pair position, char[][] board)
    {
        return (position.x >= 0 && position.y >= 0 && position.x < board.length && position.y < board[position.x].length);
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
