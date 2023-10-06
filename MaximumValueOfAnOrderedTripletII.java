// https://leetcode.com/contest/weekly-contest-365/problems/maximum-value-of-an-ordered-triplet-ii/

/*
 * Calculate left max and right max of every index, and maintain the max value.
 */

public class MaximumValueOfAnOrderedTripletII {
    public long maximumTripletValue(int[] nums) {
        int[] leftMax = new int[nums.length];
        
        // Calculate left max
        for(int i = 1; i < nums.length - 1; i++)
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
        
        // Find right max and maintain the max answer
        long answer = 0;
        for(int i = nums.length - 2; i >= 1; i--)
        {
            int rightMax = Math.max(leftMax[i + 1], nums[i + 1]);
            long currentAnswer = (long)(leftMax[i] - nums[i]) * rightMax;
            
            answer = Math.max(answer, currentAnswer);
            
            // Update the leftMax[i] with rightMax
            leftMax[i] = rightMax;
        }
        
        return answer;
    }
}
