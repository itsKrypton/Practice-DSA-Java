// https://leetcode.com/problems/accounts-merge/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Use a hashmap and store all the email and index pairs, if an email already exists, then make a union connection in a disjoint set which basically tells that the 
 * username already exists and it connects to it's parent. Loop through map entries and add the emails in the parent names list.
 */

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(accounts.size());

        // Filling DisjointSet and Map
        for(int i = 0; i < accounts.size(); i++)
        {
            for(int j = 1; j < accounts.get(i).size(); j++)
            {
                String email = accounts.get(i).get(j);

                if(map.containsKey(email))
                ds.unionBySize(map.get(email), i);

                else
                map.put(email, i);
            }
        }

        // Creating mergedlist with similar emails 
        List<List<String>> mergedMail = new ArrayList<>();

        for(int i = 0; i < accounts.size(); i++)
        mergedMail.add(new ArrayList<>());

        for(Map.Entry<String, Integer> entry : map.entrySet())
        mergedMail.get(ds.findParent(entry.getValue())).add(entry.getKey());

        // Final output
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < mergedMail.size(); i++)
        {
            if(!mergedMail.get(i).isEmpty())
            {
                List<String> currentList = new ArrayList<>();
                currentList.add(accounts.get(i).get(0));

                Collections.sort(mergedMail.get(i));
                for(String email : mergedMail.get(i))
                currentList.add(email);

                ans.add(currentList);
            }
        }
        
        return ans;
    }

    public class DisjointSet {
        private int[] size;
        private int[] parent;

        public DisjointSet(int length)
        {
            this.size = new int[length + 1];
            this.parent = new int[length + 1];

            for(int i = 0; i <= length; i++)
            {
                size[i] = 1;
                parent[i] = i;
            }
        }

        // Finds ultimate parent of the given vertex in O(4 alpha) ~ O(1) uses path compression to get this
        public int findParent(int vertex)
        {
            if(this.parent[vertex] == vertex)
            return vertex;

            return parent[vertex] = findParent(this.parent[vertex]);
        }

        // Connects the parent of node u and node v depending on their ranks/size in O(4 alpha) ~ O(1)

        // Union By Size is more intuitive so use this instead of rank.
        public void unionBySize(int u, int v)
        {
            int parentOfU = findParent(u);
            int parentOfV = findParent(v);

            // We only perform union if parents are different, if they're same then no need.
            if(parentOfU != parentOfV)
            {
                if(size[parentOfU] < size[parentOfV])
                {
                    parent[parentOfU] = parentOfV;
                    size[parentOfV] += size[parentOfU];
                }

                else
                {
                    parent[parentOfV] = parentOfU;
                    size[parentOfU] += size[parentOfV];
                }
            }
        }
    }
}
