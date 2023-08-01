// https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1

import java.util.*;

/*
 * We are doing mod 100000 for every answer, thus the total numbers we can have are from 0 to 99999. Consider these to be different nodes and simply run a level wise BFS,
 * find the end, the moment we find it, that's our minimum steps as BFS will always give us the shortest answer first.
 */

public class MinimumMultiplicationToReachEnd {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        
        int[] visited = new int[100000];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;
        
        int steps = 0;
        while(!queue.isEmpty())
        {
            int currentSize = queue.size();
            steps++;
            for(int i = 0; i < currentSize; i++)
            {
                int currentVertex = queue.remove();
                
                for(int num : arr)
                {
                    int nVertex = (currentVertex * num) % 100000;
                    
                    if(visited[nVertex] == 0)
                    {
                        if(nVertex == end)
                        return steps;
                        
                        queue.add(nVertex);
                        visited[nVertex] = 1;
                    }
                }
            }
        }
        
        return -1;
    }
}