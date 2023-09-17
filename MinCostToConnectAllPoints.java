// https://leetcode.com/problems/min-cost-to-connect-all-points/description/?envType=daily-question&envId=2023-09-15

//import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * Use prims algorithm
 */

public class MinCostToConnectAllPoints {
    // Without using adjacency list extra space
    /* public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.weight, b.weight));
        boolean[] visited = new boolean[points.length];
        int minCost = 0;

        // Add all the distances from 0th point into the PQ.
        for(int i = 1; i < points.length; i++)
        pq.add(new Edge(0, i, findDistance(0, i, points)));

        visited[0] = true;
        while(!pq.isEmpty())
        {
            Edge currentEdge = pq.remove();

            if(!visited[currentEdge.currentNode])
            {
                visited[currentEdge.currentNode] = true;
                minCost += currentEdge.weight;

                // Add the next edges from currentEdge.to into the PQ.
                for(int i = 0; i < points.length; i++)
                {
                    if(i != currentEdge.currentNode && !visited[i])
                    pq.add(new Edge(currentEdge.currentNode, i, findDistance(currentEdge.currentNode, i, points)));
                }
            }
        }

        return minCost;
    } */

    // Making the above code a bit more compact. No need of using a new class and the extra steps to add the edges from first node
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        boolean[] visited = new boolean[points.length];
        int minCost = 0;

        pq.add(new int[]{0, 0});
        while(!pq.isEmpty())
        {
            int[] currentEdge = pq.remove();

            if(!visited[currentEdge[0]])
            {
                visited[currentEdge[0]] = true;
                minCost += currentEdge[1];

                // Add the next edges from current node into the PQ.
                for(int i = 0; i < points.length; i++)
                {
                    if(i != currentEdge[0] && !visited[i])
                    pq.add(new int[]{i, findDistance(currentEdge[0], i, points)});
                }
            }
        }

        return minCost;
    }

    // Using adjacency list
    /* public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.weight, b.weight));
        boolean[] visited = new boolean[points.length];
        int minCost = 0;

        // Filling the adjacency list
        for(int i = 0; i < points.length; i++)
        {
            adj.add(new ArrayList<>());

            for(int j = 0; j < points.length; j++)
                if(i != j)
                    adj.get(i).add(new int[]{j, findDistance(i, j, points)});
        }

        pq.add(new Edge(-1, 0, 0));
        while(!pq.isEmpty())
        {
            Edge currentEdge = pq.remove();

            if(!visited[currentEdge.currentNode])
            {
                visited[currentEdge.currentNode] = true;

                if(currentEdge.parent != -1)
                minCost += currentEdge.weight;

                // Add the next edges from currentNode into the PQ.
                for(int[] nEdge : adj.get(currentEdge.currentNode))
                {
                    if(!visited[nEdge[0]])
                    pq.add(new Edge(currentEdge.currentNode, nEdge[0], nEdge[1]));
                }
            }
        }

        return minCost;
    } */

    public int findDistance(int a, int b, int[][] points)
    {
        return Math.abs(points[b][0] - points[a][0]) + Math.abs(points[b][1] - points[a][1]);
    }

    /* public class Edge {
        private int parent;
        private int currentNode;
        private int weight;

        public Edge(int parent, int currentNode, int weight) {
            this.parent = parent;
            this.currentNode = currentNode;
            this.weight = weight;
        }
    } */
}
