// https://leetcode.com/problems/single-element-in-a-sorted-array/description/

/* Perform binary search for O(log n) as the array is already sorted. For every number, check if it's previous or next value is same and take appropriate actions. */

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;

        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(mid%2 == 0)
            {
                if(mid < nums.length - 1 && nums[mid + 1] == nums[mid])
                start = mid + 1;

                else if(mid > 0 && nums[mid - 1] == nums[mid])
                end = mid - 1;

                else
                return nums[mid];
            }

            else
            {
                if(mid < nums.length - 1 && nums[mid + 1] == nums[mid])
                end = mid - 1;

                else if(mid > 0 && nums[mid - 1] == nums[mid])
                start = mid + 1;

                else
                return nums[mid];
            }
        }

        return -1;
    }
}
