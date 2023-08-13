// https://leetcode.com/problems/max-pair-sum-in-an-array/

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MaxPairSumInAnArray {
    public int maxSum(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int i = 0; i <= 9; i++)
        map.put(i, new PriorityQueue<>(Collections.reverseOrder()));
        
        for(int num : nums)
        {
            int maxDigit = getMaxDigit(num);
            map.get(maxDigit).add(num);
        }
        
        int max = -1;
        for(int i = 0; i <= 9; i++)
        {
            if(map.get(i).size() > 1)
            max = Math.max(max, map.get(i).remove() + map.get(i).remove());
        }
        
        return max;
    }
    
    private int getMaxDigit(int num) {
        int maxDigit = 0;
        while (num > 0) {
            maxDigit = Math.max(maxDigit, num % 10);
            num /= 10;
        }
        return maxDigit;
    }
}
