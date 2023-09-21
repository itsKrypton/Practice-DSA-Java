//import java.util.Arrays;
//import java.util.HashMap;

public class MinimumOperationsToReduceXToZero {

    // To get the minimum cancellations on the sides, we basically need to find the longest subsequence in the center whose sum is totalSum - x. Then the answer would
    // be total length - size of max window.
    public int minOperations(int[] nums, int x) {
        //int totalSum = Arrays.stream().sum();
        long totalSum = 0;

        for(int num : nums)
            totalSum += num;

        if(totalSum == x) return nums.length;

        else if(totalSum < x) return -1;

        // Now we basically just need to find the longest subsequence with the sum target
        long target = totalSum - x;

        int low = 0, maxWindow = -1;
        long currentSum = 0;
        for(int high = 0; high < nums.length; high++)
        {
            currentSum += nums[high];

            while(low <= high && currentSum > target)
            {
                currentSum -= nums[low];
                low++;
            }

            if(currentSum == target)
                maxWindow = Math.max(maxWindow, high - low + 1);
        }

        return (maxWindow == -1) ? -1 : nums.length - maxWindow;
    }

    // One way to do it using HashMap where we store the suffix sums and for a particular prefix sum, we find it's suffix sum which adds up to the target x. We find 
    // the minimum operations for all of this.
    // T: O(2n) S: O(n)
    /* public int minOperations(int[] nums, int x) {
        HashMap<Long, Integer> sufSumMap = new HashMap<>();

        long sufSum = 0;
        for(int i = nums.length - 1; i >= 0; i--)
        {
            sufSum += nums[i];
            sufSumMap.put(sufSum, i);
        }

        if(sufSum < x) return -1;

        int minOperations = (sufSumMap.containsKey((long)x)) ? nums.length - sufSumMap.get((long)x) : Integer.MAX_VALUE;
        long prefSum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            prefSum += nums[i];
            if(prefSum > x) break;

            else if(prefSum == x)
            {
                minOperations = Math.min(minOperations, i + 1);
                continue;
            }

            long remaining = x - prefSum;
            if(sufSumMap.containsKey(remaining))
            minOperations = Math.min(minOperations, (nums.length - sufSumMap.get(remaining)) + i + 1);
        }

        return (minOperations == Integer.MAX_VALUE) ? -1 : minOperations;
    } */
}
