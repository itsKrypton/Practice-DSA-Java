// https://leetcode.com/problems/reconstruct-itinerary/?envType=daily-question&envId=2023-09-14

//import java.util.ArrayList;
//import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
//import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {
    // Using HashMap with LinkedList and traversing until we find the correct itinerary.
    /* public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, LinkedList<String>> adj = new HashMap<>();
        int totalTickets = tickets.size();

        // Prepare adjacency list
        for(List<String> ticket : tickets)
        {
            adj.putIfAbsent(ticket.get(0), new LinkedList<>());
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        // Sort the list
        for(Map.Entry<String, LinkedList<String>> entry : adj.entrySet())
        Collections.sort(entry.getValue());

        List<String> ans = new ArrayList<>();
        ans.add("JFK");
        dfs("JFK", adj, ans, totalTickets);

        return ans;
    }

    public void dfs(String currentVertex, HashMap<String, LinkedList<String>> adj, List<String> ans, int totalTickets)
    {
        if(ans.size() == totalTickets + 1 || !adj.containsKey(currentVertex)) return;
        
        int lengthOfList = adj.get(currentVertex).size();
        for(int i = 0; i < lengthOfList; i++)
        {
            // Take the first guy
            String nVertex = adj.get(currentVertex).get(0);
            adj.get(currentVertex).removeFirst();
            ans.add(nVertex);

            dfs(nVertex, adj, ans, totalTickets);
            if(ans.size() == totalTickets + 1) return;

            adj.get(currentVertex).add(nVertex);
            ans.remove(ans.size() - 1);
        }
    } */

    // Using HashMap with Priority Queue to make sure we choose the lexicographically smaller names first and find their linear ordering.
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();

        // Prepare adjacency list
        for(List<String> ticket : tickets)
        {
            adj.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        LinkedList<String> ans = new LinkedList<>();
        dfs("JFK", adj, ans);

        return ans;
    }

    public void dfs(String currentVertex, HashMap<String, PriorityQueue<String>> adj, LinkedList<String> ans)
    {
        PriorityQueue<String> currentList = adj.get(currentVertex);
        
        while(currentList != null && !currentList.isEmpty())
            dfs(currentList.poll(), adj, ans);

        ans.addFirst(currentVertex);
    }
}
