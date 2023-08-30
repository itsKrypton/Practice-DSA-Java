// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

public class FindMinimumInRotatedSortedArray {
    /*
     * We just need to find the beginning of the original array, thus, while the mid is >= end, we keep going checking to the right. If it's not, then we need to check
     * the left to find the starting of the array.
     */

    public int findMin(int[] nums) {
        int low = 0, end = nums.length - 1;

        while(low < end)
        {
            int mid = low + (end - low) / 2;

            if(nums[mid] >= nums[end])
            low = mid + 1;

            else
            end = mid;
        }

        return nums[low];
    }
}
