//https://leetcode.com/problems/split-array-largest-sum/

/*
 * To solve this problem, you need to find the lowercase and uppercase of all the possible answers of the problem.
 * E.g when the array is 7,2,5,10,8 
 * 
 * Case max m would be 5, where you will split the array into 5 subarrays and there the answer would be max of all those subarrays, which is 10.
 * Case min m would be 1, where you will split the array into 1 subarray which is the array itself, so upperbound would be sum of all numbers in array, i.e. 32
 * 
 * Now do binary search between 10 and 32 to go through all the possible answers and check whether at that particular answer if the number of sub arrays created
 * exceeds the given "m" or not.
 * 
 * Time: O(nlogn)
 */

public class SplitArrayLargestSum {
    public static void main(String args[])
    {
        int nums[] = {7,2,5,10,8};
        int m = 2;
        System.out.println(splitArray(nums, m));
    }

    public static int splitArray(int[] nums, int m) {
        int lowerBound = Integer.MIN_VALUE, upperBound = 0;

        for(int num : nums)
        {
            lowerBound = Math.max(lowerBound, num);
            upperBound += num;
        }

        while(lowerBound < upperBound)
        {
            int mid = lowerBound + (upperBound - lowerBound)/2;

            int sum=0;
            int subArrays = 1;
            for(int num : nums)
            {
                if(sum + num > mid)
                {   
                    sum = 0;
                    subArrays++;
                }

                sum += num;
            }

            if(subArrays > m)
            lowerBound = mid + 1;

            else
            upperBound = mid;
        }

        return upperBound;
    }
}
