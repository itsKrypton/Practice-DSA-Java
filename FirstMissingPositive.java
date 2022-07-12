//https://leetcode.com/problems/first-missing-positive/submissions/

/*
 * To solve this problem use cyclic sort to first sort the elements, ignoring elements less than 0 and greater than length of array.
 * Then run a loop through the elements and index + 1 of the first wrong element is the answer. If all the elements are at right position then nums.length + 1 is 
 * answer.
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length)
        {
            int correct = nums[i] - 1;
            if(nums[i] < nums.length && nums[i] > 0 && nums[i] != nums[correct])
            {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }

            else
            i++;
        }

        for(i = 0; i < nums.length; i++)
        {
            if(nums[i] != i + 1)
            return i + 1;
        }

        return nums.length + 1;
    }
}
