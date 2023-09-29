// https://leetcode.com/problems/sort-array-by-parity/description/?envType=daily-question&envId=2023-09-28

/*
 * Similar to quick sort pivot approach, here we move the pointers until the left pointer is not even and right pointer is not odd, then swap both the numbers.
 */

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int low = 0, high = nums.length - 1;

        while(low < high)
        {
            // Move low pointer until the number is not even
            while(low < high && nums[low] % 2 == 0)
                low++;

            // Move the high pointer until the number is not odd
            while(low < high && nums[high] % 2 != 0)
                high--;

            // Swap both the numbers
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;

            low++;
            high--;
        }

        return nums;
    }
}
