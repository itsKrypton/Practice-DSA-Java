// https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Used for single source shortest distance but with negative weight cycles. Simply have a distance array and relax it n-1 times as at worse case, it'll take that many
 * iterations to find the shortest distances. To find the negative cycles, run one more iteration and if the distances are further reduced then it means that the graph
 * contains negative cycles.
 * T: V*E
 */

public class DistanceFromTheSourceBellmanFordAlgo {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distance = new int[V];
        
        Arrays.fill(distance, (int)(1e8));
        distance[S] = 0;
        
        // Running it for N times for negative cycle detection
        for(int i = 0; i < V; i++)
        {
            for(ArrayList<Integer> edge : edges)
            {
                int currentVertex = edge.get(0);
                int nVertex = edge.get(1);
                int weight = edge.get(2);
                
                if(distance[currentVertex] != (int)(1e8) && distance[currentVertex] + weight < distance[nVertex])
                {
                    if(i == V - 1) // Last iteration for negative cycle detection
                    return new int[]{-1};
                    
                    distance[nVertex] = distance[currentVertex] + weight;
                }
            }
        }
        
        return distance;
    }
}
