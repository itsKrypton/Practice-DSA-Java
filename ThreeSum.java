//https://leetcode.com/problems/3sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public static void main(String args[])
    {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> answer = threeSum(nums);
        System.out.println(answer);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        HashSet<List<Integer>> mySet = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++)
        {
            if(i == 0 || (i>0 && nums[i] != nums[i-1]))
            {
                int start = i + 1;
                int end = nums.length - 1;

                while(start < end)
                {
                    if(nums[i] + nums[start] + nums[end] < 0)
                    start++;

                    else if(nums[i] + nums[start] + nums[end] > 0)
                    end--;

                    else
                    {
                        List<Integer> answer = new ArrayList<>();
                        answer.add(nums[i]);
                        answer.add(nums[start]);
                        answer.add(nums[end]);
                        if(!mySet.contains(answer))
                        {
                            answers.add(answer);
                            mySet.add(answer);
                        }

                        start++;
                        end--;
                    }
                }
            }
        }

        return answers;
    }
}
