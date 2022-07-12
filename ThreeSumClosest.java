//https://leetcode.com/problems/3sum-closest/

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String args[])
    {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums, 1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int answer = nums[0] + nums[1] + nums[2];

        for(int i = 0;i < nums.length - 2; i++)
        {
            int start = i+1;
            int end = nums.length - 1;

            while(start < end)
            {
                int currentSum = nums[i] + nums[start] + nums[end];
                answer = (Math.abs(currentSum - target) < Math.abs(answer - target)) ? currentSum : answer;

                if(currentSum < target)
                start++;

                else if(currentSum > target)
                end--;

                else
                return currentSum;
            }
        }
        return answer;
    }
}
