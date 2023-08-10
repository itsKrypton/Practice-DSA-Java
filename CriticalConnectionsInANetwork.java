//https://leetcode.com/problems/critical-connections-in-a-network/description/

import java.util.*;

/*
 * To find the links which separate the graph, use timeToReach and lowestTime arrays in a DFS. Time to reach is the time taken to reach a particular node and the lowest
 * time is the lowest time node you can reach from the current node. For every nVertex of a currentVertex, check if it's not visited (visit in that case), or if it's 
 * visited and it's not the parent vertex, then take the lowest time node of the nVertex and set it as lowest time node of the current vertex, if it's less than the
 * current time. Pass it to the parent vertex and also check, if the lowest time is greater than the current vertex's time taken, if it is then it means that
 * the nVertex was not able to reach any other node which has less time than the current node, thus, it's a weak link and we can have it as our answer.
 */

public class CriticalConnectionsInANetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        List<List<Integer>> answers = new ArrayList<>();

        for(int i = 0; i < n; i++)
        adj.add(new ArrayList<>());

        for(List<Integer> connection : connections)
        {
            adj.get(connection.get(0)).add(connection.get(1));
            adj.get(connection.get(1)).add(connection.get(0));
        }

        int[] timeToReach = new int[n];
        int[] lowestTime = new int[n];

        for(int i = 0; i < n; i++)
        {
            if(timeToReach[i] == 0)
            dfs(i, -1, new int[]{1}, adj, timeToReach, lowestTime, answers);
        }

        return answers;
    }

    public void dfs(int currentVertex, int parentVertex, int[] currentTime, ArrayList<ArrayList<Integer>> adj, int[] timeToReach, int[] lowestTime, List<List<Integer>> answers)
    {
        timeToReach[currentVertex] = lowestTime[currentVertex] = currentTime[0];

        for(int nVertex : adj.get(currentVertex))
        {
            if(timeToReach[nVertex] == 0)
            {
                currentTime[0]++;
                dfs(nVertex, currentVertex, currentTime, adj, timeToReach, lowestTime, answers);

                lowestTime[currentVertex] = Math.min(lowestTime[currentVertex], lowestTime[nVertex]);

                if(lowestTime[nVertex] > timeToReach[currentVertex])
                answers.add(Arrays.asList(currentVertex, nVertex));
            }

            else if(nVertex != parentVertex)
            lowestTime[currentVertex] = Math.min(lowestTime[currentVertex], lowestTime[nVertex]);
        }
    }
}
