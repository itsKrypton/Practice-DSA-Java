// https://leetcode.com/problems/number-of-provinces/

//import java.util.ArrayList;

public class NumberOfProvinces {
    // By creating adjacency list, extra space

    /* public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < isConnected.length; i++)
        adj.add(new ArrayList<>());

        for(int i = 0; i < isConnected.length; i++)
        {
            for(int j = 0; j < isConnected[i].length; j++)
            {
                if(isConnected[i][j] == 1 && i != j)
                {
                    adj.get(i).add(j + 1);
                    adj.get(j).add(i + 1);
                }
            }
        }

        boolean[] visited = new boolean[isConnected.length + 1];
        int numberOfProvinces = 0;
        for(int i = 0; i < isConnected.length; i++)
        {
            if(!visited[i + 1])
            {
                numberOfProvinces++;
                dfs(i + 1, adj, visited);
            }
        }

        return numberOfProvinces;
    }

    public static void dfs(int currentVertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
    {
        for(int nVertex : adj.get(currentVertex - 1))
        {
            if(!visited[nVertex])
            {
                visited[nVertex] = true;
                dfs(nVertex, adj, visited);
            }
        }
    } */

    //Without adjacency list using the given adjacency matrix

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length + 1];
        int numberOfProvinces = 0;
        for(int i = 0; i < isConnected.length; i++)
        {
            if(!visited[i + 1])
            {
                numberOfProvinces++;
                dfs(i + 1, isConnected, visited);
            }
        }

        return numberOfProvinces;
    }

    public static void dfs(int currentVertex, int[][] isConnected, boolean[] visited)
    {
        for(int nVertex = 0; nVertex < isConnected[currentVertex - 1].length; nVertex++)
        {
            if(currentVertex != (nVertex + 1) && isConnected[currentVertex - 1][nVertex] == 1 && !visited[nVertex + 1])
            {
                visited[nVertex + 1] = true;
                dfs(nVertex + 1, isConnected, visited);
            }
        }
    }
}
