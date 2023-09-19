// https://leetcode.com/problems/happy-students/

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * Add the count of the numbers and their count in a treemap as we want it to be sorted. Traverse through the map and for every current student, see if the total
 * students is greater than it and the total students is also less than the previous students. If yes, increment the number of ways. Decrement the total students 
 * count by current students count as we don't need to select those students for the next iteration.
 */

public class HappyStudents {
    public int countWays(List<Integer> nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        int totalStudents = nums.size();
        
        for(int num : nums)
        map.put(num, map.getOrDefault(num, 0) + 1);
        
        int totalWays = 0;
        int lastStudents = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int current = entry.getKey();
            
            if(totalStudents > current && totalStudents < lastStudents)
                totalWays++;
            
            totalStudents -= entry.getValue();
            lastStudents = current;
        }
        
        return (!map.containsKey(0)) ? totalWays + 1 : totalWays;
    }
}
