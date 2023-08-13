// https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/description/

/*
 * The minimum distance needs to be X, thus we will start traversing from x index in the given array. Every time we insert the (i - x)th element inside the treeset.
 * For every current element, we need to find the closest element greater than it and less that it as that will give us the minimum difference. Thus, we use set.ceiling
 * and set.floor methods to let the treeset find it for us. Do this for all the indexes from x to the end of the list.
 */

import java.util.List;
import java.util.TreeSet;

public class MinAbsDiffBetweenElementsWithConstraint {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set = new TreeSet<>();

        int minDiff = Integer.MAX_VALUE;
        for(int i = x; i < nums.size(); i++)
        {
            set.add(nums.get(i - x));

            Integer ceil = set.ceiling(nums.get(i));
            if(ceil != null)
            minDiff = Math.min(minDiff, Math.abs(nums.get(i) - ceil));

            Integer floor = set.floor(nums.get(i));
            if(floor != null)
            minDiff = Math.min(minDiff, Math.abs(nums.get(i) - floor));
        }

        return minDiff;
    }
}
