//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/ and https://practice.geeksforgeeks.org/problems/number-of-ways-to-arrive-at-destination/1

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * As we need to store all the possible ways, we will take an extra ways array which will store the ways of every node. If new distance is less than current distance, then
 * add it in queue and update the ways array.
 */

public class NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, int[][] roads) {
        int mod = (int)(1e9 + 7);
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        long[] distance = new long[n];
        int[] ways = new int[n];

        for(int i = 0; i < n; i++)
        {
            distance[i] = Long.MAX_VALUE;
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads)
        {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> Long.compare(a.dist, b.dist));
        queue.add(new Pair(0, 0));

        while(!queue.isEmpty())
        {
            Pair currentVertex = queue.remove();

            for(Pair nVertexPair : adj.get(currentVertex.node))
            {
                int nVertex = nVertexPair.node;
                long newDist = currentVertex.dist + nVertexPair.dist;

                if(newDist <= distance[nVertex])
                {
                    if(newDist < distance[nVertex])
                    {
                        queue.add(new Pair(nVertex, newDist)); // Only add in queue if newDist is less and not equal to current distance.
                        ways[nVertex] = 0; // We found new minimum so reset ways of that node to 0.
                    }

                    ways[nVertex] = (ways[nVertex] + ways[currentVertex.node]) % mod; // Increment current ways by previous ways.
                    distance[nVertex] = newDist;
                }
            }
        }

        return (int)(ways[n - 1]);
    }

    public class Pair {
        private int node;
        private long dist;

        public Pair(int node, long dist)
        {
            this.node = node;
            this.dist = dist;
        }
    }
}
