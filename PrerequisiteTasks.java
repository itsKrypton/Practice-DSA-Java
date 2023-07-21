// https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1 and https://leetcode.com/problems/course-schedule/description/ (Course Schedule)
// https://practice.geeksforgeeks.org/problems/course-schedule/1 (Same problem as above just return the toposort in the end as well)

/*
 * Because we know that a particular task should always be before another task thus we can see a depedency of one task to another which shows a directed graph. We can
 * create a graph first and then perform BFS topo sort (Kahns Algo) to get the linear ordering of the graph. If the topo sort's size is same as the total nodes then
 * the answer is true.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrerequisiteTasks {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Create the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < N; i++)
        adj.add(new ArrayList<>());
        
        for(int[] pre : prerequisites)
        adj.get(pre[1]).add(pre[0]);
        
        // Create indegree array
        int[] indegree = new int[N];
        
        for(int i = 0; i < N; i++)
        {
            for(int nVertex : adj.get(i))
            indegree[nVertex]++;
        }
        
        // Add the nodes with indegree 0 to queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < N; i++)
        {
            if(indegree[i] == 0)
            queue.add(i);
        }
        
        // Do O(V + E) BFS traversal
        ArrayList<Integer> topoSort = new ArrayList<>();
        
        while(!queue.isEmpty())
        {
            int currentNode = queue.remove();
            topoSort.add(currentNode);
            
            for(int nVertex : adj.get(currentNode))
            {
                if(--indegree[nVertex] == 0)
                queue.add(nVertex);
            }
        }
        
        return (topoSort.size() == N);
    }
}
