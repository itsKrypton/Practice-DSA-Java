// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/ and https://practice.geeksforgeeks.org/problems/cheapest-flights-within-k-stops/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * We can't do normal dijkstra's as normally it finds the shortest distance, it doesn't care about the steps taken. Here we need to find the shortest distance but within
 * k steps. Thus, take normal queue as we need to check all possibilities within the k steps. if steps goes over k then don't check further and at the end return the 
 * distance of destination.
 */

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] distance = new int[n];

        for(int i = 0; i < n; i++)
        {
            adj.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        distance[src] = 0;

        for(int[] flight : flights)
        adj.get(flight[0]).add(new int[]{flight[1], flight[2]});

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0, 0});

        while(!queue.isEmpty())
        {
            int[] currentVertex = queue.remove();

            if(currentVertex[2] <= k)
            {
                for(int[] nVertexList : adj.get(currentVertex[0]))
                {
                    int nVertex = nVertexList[0];
                    int price = nVertexList[1];

                    if(currentVertex[1] + price < distance[nVertex])
                    {
                        distance[nVertex] = currentVertex[1] + price;
                        queue.add(new int[]{nVertex, distance[nVertex], currentVertex[2] + 1});
                    }
                }
            }
        }

        return (distance[dst] == Integer.MAX_VALUE) ? -1 : distance[dst];
    }
}
