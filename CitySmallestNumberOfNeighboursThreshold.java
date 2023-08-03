// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/submissions/

/*
 * Simply find the smallest distance from a vertex to all the vertices. You can use Dijkstra's v times or simply the floyd warshall algorithm. Then just calculate which
 * cities have neighbour cities with less than threshold distance and track the city with the minimum count.
 */

public class CitySmallestNumberOfNeighboursThreshold {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];

        for(int[] edge : edges)
        {
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == j)
                continue;

                if(distance[i][j] == 0)
                distance[i][j] = (int)(1e9);
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                for(int k = 0; k < n; k++)
                distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
            }
        }

        int smallestNeighboursCity = 0;
        int smallestNeighbours = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++)
        {
            int currentNeighbours = 0;
            for(int j = 0; j < n; j++)
            {
                if(i == j)
                continue;

                if(distance[i][j] <= distanceThreshold)
                currentNeighbours++;
            }

            if(currentNeighbours <= smallestNeighbours)
            {
                smallestNeighbours = currentNeighbours;
                smallestNeighboursCity = i;
            }
        }

        return smallestNeighboursCity;
    }
}
