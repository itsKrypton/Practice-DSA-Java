import java.util.*;

public class FindTheLongestEqualSubarray {

    /*
     * Keep a track of count of all elements and the maxFrequency of elements so far. For every window, check the numbers that we will have to remove, if that is greater
     * than K then we will have to reduce the sliding window.
     */

    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, maxFrequency = 0;

        for(int j = 0; j < nums.size(); j++)
        {
            map.put(nums.get(j), map.getOrDefault(nums.get(j), 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(nums.get(j)));

            if(j - i + 1 - maxFrequency > k)
            {
                map.put(nums.get(i), map.get(nums.get(i)) - 1);
                i++;
            }
        }

        return maxFrequency;
    }
}
