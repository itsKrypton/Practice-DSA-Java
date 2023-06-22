// https://leetcode.com/problems/permutations/description/

/*
 * Don't carry an index with you in recursion, instead, start with the 0th index every time because you want to check for every index element in permutation.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsArray {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        helper(nums, set, new ArrayList<>(), answer);

        return answer;
    }

    public void helper(int[] nums, HashSet<Integer> set, List<Integer> currList, List<List<Integer>> answer)
    {
        if(currList.size() == nums.length)
        {
            answer.add(new ArrayList<>(currList));
            return;
        }

        for(int i = 0; i < nums.length; i++)
        {
            if(set.add(nums[i]))
            {
                currList.add(nums[i]);
                helper(nums, set, currList, answer);
                currList.remove(currList.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
}
