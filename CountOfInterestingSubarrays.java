// https://leetcode.com/problems/count-of-interesting-subarrays/description/

import java.util.HashMap;
import java.util.List;

public class CountOfInterestingSubarrays {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        // Construct a flagArray having 1's and 0's where 1 signifies that nums[i] % modulo == k
        int[] flagArray = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++)
        flagArray[i] = (nums.get(i) % modulo == k) ? 1 : 0;

        // Find subarray of sum of 1's % modulo == k
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        long countOfSubarrays = 0;
        int prefSum = 0;

        for(int i = 0; i < nums.size(); i++)
        {
            // Sum till now
            prefSum += flagArray[i];

            // Need to get the number of subarrays with sum as Sum - k % modulo.
            int remainder = (prefSum - k) % modulo;

            // Get the count of subarrays with remainder sum as those subarrays we can remove and get the sum as k.
            if(map.containsKey(remainder))
            countOfSubarrays += map.get(remainder);

            // Update the count of prefsum % modulo subarrays.
            map.put(prefSum % modulo, map.getOrDefault(prefSum % modulo, 0) + 1);
        }

        return countOfSubarrays;
    }
}
