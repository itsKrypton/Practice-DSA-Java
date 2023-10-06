// https://leetcode.com/problems/minimum-size-subarray-in-infinite-array/

public class MinimumSizeSubarrayInInfiniteArray {

    /*
     * If target is more than sum then we will definitely have nums.length * (target / sum) length of numbers as our answer. For our remaining target, we just need 
     * to find the minimum subarray length of sum equal to target but the only change that the subarray can be circular for example,
     *    1 2 3 4 5 6
     *          |----
     *    --|
     * 
     *    Subarray from index 3 to 1.
     * 
     * The final answer would be initial number of elements + the elements in the minimum subarray of sum equal to target
     */

    public int minSizeSubarray(int[] nums, int target) {
        long sum = 0;

        for(int num : nums)
            sum += num;

        int lengthOfCurrentSubarray = 0;
        if(target > sum)
        {
            lengthOfCurrentSubarray += nums.length * (target / sum); 
            
            // remaining target
            target %= sum;
        }

        if(target == 0)
        return lengthOfCurrentSubarray;

        int lengthOfRemainingTarget = find(nums, target);
        return (lengthOfRemainingTarget == Integer.MAX_VALUE) ? -1 : lengthOfRemainingTarget + lengthOfCurrentSubarray;
    }

    public int find(int[] nums, int target)
    {
        long sum = 0;
        int low = 0, minLength = Integer.MAX_VALUE;
        for(int high = 0; high < nums.length * 2; high++)
        {
            sum += nums[high % nums.length];

            while(low < high && sum > target)
                sum -= nums[low++ % nums.length];

            if(sum == target)
                minLength = Math.min(minLength, high - low + 1);
        }

        return minLength;
    }
}
