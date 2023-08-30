// https://leetcode.com/problems/minimum-replacements-to-sort-the-array/description/

public class MinimumReplacementsToSortTheArray {
    /*
     * We start from back as we can't increase the next number in case the current number is smaller than it but we can always decrease the previous number in case
     * the current number is greater than it. We carry the last number and calculate the number of operations we need to make when we divide the current number in 
     * such a way that the second part is always smaller than the previous number.
     */
    public long minimumReplacement(int[] nums) {
        int lastNumber = nums[nums.length - 1];
        long operations = 0;
        for(int i = nums.length - 2; i >= 0; i--)
        {
            if(nums[i] > lastNumber)
            {
                int currentOperations = (nums[i] - 1) / lastNumber;
                operations += currentOperations;

                lastNumber = nums[i] / (currentOperations + 1);
            }

            else
            lastNumber = nums[i];
        }

        return operations;
    }
}
