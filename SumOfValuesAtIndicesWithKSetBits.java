// https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/

import java.util.List;

/*
 * Find the set bits of the index and see if it's equal to k, simple brute force.
 */

public class SumOfValuesAtIndicesWithKSetBits {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int result = 0;
        
        for(int i = 0; i < nums.size(); i++)
        {
            int setBits = 0;
            int temp = i;
            
            while(temp > 0)
            {
                setBits += (temp & 1);
                temp = (temp >> 1);
            }
            
            if(setBits == k)
                result += nums.get(i);
        }
        
        return result;
    }
}
