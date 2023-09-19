//https://leetcode.com/problems/minimum-array-length-after-pair-removals/description/

import java.util.List;

/*
 * Find the count of the maximum occuring element and calculate the cancellations according to it.
 */

public class MinimumArrayLengthAfterPairRemovals {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int maxCount = 1;

        for(int i = 0; i < nums.size() - 1; i++)
        {
            int currentCount = 1;

            while(i < nums.size() - 1 && nums.get(i).equals(nums.get(i + 1)))
            {
                i++;
                currentCount++;
            }

            maxCount = Math.max(maxCount, currentCount);
        }

        // If the maxCount <= nums.size() then it will have zero or one element at the end depending on the size of array, if it's even or odd respectively.
        if(maxCount <= nums.size() / 2)
            return (nums.size() % 2 == 0) ? 0 : 1;

        else
            // maxCount - (nums.size() - maxCount) elements will be left after all cancellations
            return (2 * maxCount - nums.size());
    }
}
