// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/description/?envType=daily-question&envId=2023-09-11

import java.util.ArrayList;
//import java.util.Collections;
import java.util.HashMap;
import java.util.List;
//import java.util.Map;

public class GroupPeopleByGroupSize {
    // Sorting nlogn
    /* public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<int[]> groupAndIdx = new ArrayList<>();

        for(int i = 0; i < groupSizes.length; i++)
        groupAndIdx.add(new int[]{groupSizes[i], i});

        Collections.sort(groupAndIdx, (a,b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> answers = new ArrayList<>();
        for(int i = 0; i < groupAndIdx.size();)
        {
            List<Integer> ans = new ArrayList<>();
            int currentSize = groupAndIdx.get(i)[0];

            for(int j = 0; j < currentSize; j++)
            ans.add(groupAndIdx.get(i++)[1]);

            answers.add(ans);
        }

        return answers;
    } */

    // Using hashmap, O(n + n) ~ O(n)
    /* public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // Add index group mappings in a hashmap
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++)
        {
            List<Integer> currentList = map.getOrDefault(groupSizes[i], new ArrayList<>());
            currentList.add(i);
            map.put(groupSizes[i], currentList);
        }

        // Make lists out of it.
        List<List<Integer>> answers = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet())
        {
            List<Integer> currentList = entry.getValue();
            int groupSize = entry.getKey();

            for(int i = 0; i < currentList.size();)
            {
                List<Integer> ans = new ArrayList<>();
                for(int j = 0; j < groupSize; j++)
                    ans.add(currentList.get(i++));

                answers.add(ans);
            }     
        }

        return answers;
    } */

    // O(n) single pass, HashMap + Greedy
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> answers = new ArrayList<>();

        for(int i = 0; i < groupSizes.length; i++)
        {
            // Add the current index in the list of it's respective size
            int currentSize = groupSizes[i];
            map.putIfAbsent(currentSize, new ArrayList<>());
            map.get(currentSize).add(i);

            // Check if the length of the list in currentSize is equal to currentSize. If yes, then add it to our answer and remove the list.
            if(map.get(currentSize).size() == currentSize)
            {
                answers.add(map.get(currentSize));
                map.remove(currentSize);
            }
        }

        return answers;
    }
}
