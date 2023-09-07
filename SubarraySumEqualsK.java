// https://leetcode.com/problems/subarray-sum-equals-k/description/

import java.util.HashMap;

/*
 * Keep a track of cumulative sum till now and to get a sum of k, we need to remove prefSum - k from the back. Hence, store a count of prefSum in a hashmap to get the
 * number of subarrays for the sum k till the current index.
 */

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int prefSum = 0;
        int subarrayCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int num : nums)
        {
            prefSum += num;
            int remainder = prefSum - k;

            if(map.containsKey(remainder))
            subarrayCount += map.get(remainder);

            map.put(prefSum, map.getOrDefault(prefSum, 0) + 1);
        }

        return subarrayCount;
    }
}
