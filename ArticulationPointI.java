// https://practice.geeksforgeeks.org/problems/articulation-point-1/1

/*
 * Similar to CriticalConnectionsInANetwork but there we had to find edges which separate the component, here we need to find the nodes. Just add the logic of HashSet,
 * as we can have multiple childs which would say a particular node to be an articulation point but we only need to count it once. For the first node, it will only be an
 * articulation point if it has multiple childs declaring it as an articulation point.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ArticulationPointI {
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        int[] timeToReach = new int[V];
        int[] lowestTime = new int[V];
        HashSet<Integer> markNodes = new HashSet<>();

        for(int i = 0; i < V; i++)
        {
            if(timeToReach[i] == 0)
            dfs(i, -1, new int[]{1}, adj, timeToReach, lowestTime, markNodes);
        }

        ArrayList<Integer> answers = new ArrayList<>(markNodes);
        Collections.sort(answers);
        
        if(answers.isEmpty()) 
        answers.add(-1);
        
        return answers;
    }
    
    public void dfs(int currentVertex, int parentVertex, int[] currentTime, ArrayList<ArrayList<Integer>> adj, int[] timeToReach, int[] lowestTime, HashSet<Integer> markNodes)
    {
        timeToReach[currentVertex] = lowestTime[currentVertex] = currentTime[0];
        int childs = 0;

        for(int nVertex : adj.get(currentVertex))
        {
            if(timeToReach[nVertex] == 0)
            {
                childs++;
                currentTime[0]++;
                dfs(nVertex, currentVertex, currentTime, adj, timeToReach, lowestTime, markNodes);

                lowestTime[currentVertex] = Math.min(lowestTime[currentVertex], lowestTime[nVertex]);

                if(lowestTime[nVertex] >= timeToReach[currentVertex] && parentVertex != -1)
                markNodes.add(currentVertex);
            }

            else if(nVertex != parentVertex)
            lowestTime[currentVertex] = Math.min(lowestTime[currentVertex], timeToReach[nVertex]);
        }
        
        if(childs > 1 && parentVertex == -1)
        markNodes.add(currentVertex);
    }
}
