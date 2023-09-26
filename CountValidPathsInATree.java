// https://leetcode.com/problems/count-valid-paths-in-a-tree/

import java.util.ArrayList;
import java.util.List;

/*
 * Keep a track of zero prime paths and one prime paths of every node in a dfs and calculate their paths with the zero prime children and one prime children of current
 * node. 
 */

public class CountValidPathsInATree {
    public long countPaths(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        long[] totalPaths = new long[1];
        find(1, -1, adj, totalPaths);

        return totalPaths[0];
    }

    public int[] find(int currentNode, int prevNode, List<List<Integer>> adj, long[] totalPaths)
    {
        boolean isCurrentNodePrime = isPrime(currentNode);
        int zeroPrimeChildren = 0;
        int onePrimeChildren = 0;

        for(int nNode : adj.get(currentNode))
        {
            if(nNode != prevNode)
            {
                int[] nextNode = find(nNode, currentNode, adj, totalPaths);

                // If current node is prime, then it can make paths with all zero prime childeren and the zero prime children of next
                // node. It will also make a path with itself and zero prime children of next node.
                if(isCurrentNodePrime)
                    totalPaths[0] += (zeroPrimeChildren + 1) * nextNode[0];
                /*
                 * else, we can form paths with current prime children and non prime children of next node, and current non prime children
                 * with prime children of next node. It will also make a path with itself and prime children of next node.
                 */
                else
                {
                    totalPaths[0] += onePrimeChildren * nextNode[0];
                    totalPaths[0] += (zeroPrimeChildren + 1) * nextNode[1];
                }

                zeroPrimeChildren += nextNode[0];
                onePrimeChildren += nextNode[1];
            }
        }

        int[] currentNodePaths = new int[2];

        // Total zero prime paths including current node will be,
        // 0 in case the current node is prime (as current prime node will always be considered)
        // else, paths with zero prime children plus current node is also zero prime path
        currentNodePaths[0] = (isCurrentNodePrime) ? 0 : zeroPrimeChildren + 1;
        
        // Total one prime paths including current node will be,
        // if current node is prime, paths with zero prime children + it itself will be a path
        // else, paths with total one prime children
        currentNodePaths[1] = (isCurrentNodePrime) ? zeroPrimeChildren + 1 : onePrimeChildren;
        return currentNodePaths;
    }

    public boolean isPrime(int currentNode)
    {
        if(currentNode == 1) return false;

        for(int i = 2; i <= (int)Math.sqrt(currentNode); i++)
        {
            if(currentNode % i == 0)
                return false;
        }

        return true;
    }
}
