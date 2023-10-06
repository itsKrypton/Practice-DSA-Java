// https://leetcode.com/problems/132-pattern/?envType=daily-question&envId=2023-09-30

import java.util.Stack;
//import java.util.TreeSet;

public class OneThreeTwoPattern {

    /*
     * Better approach is to use a monotonic stack for our j and k values. We will maintain a decreasing monotonic stack which will give us the greatest smaller
     * element to the right of a number when we traverse from the end of the array. Whenever we come across a number which is greater than the top of the stack,
     * keep popping the elements till it's not greater any more. The last popped element will be the greatest smaller element to the current element. Thus, we can
     * make the popped element the third element, the current element our second element, and we just need to find the first element that will be any element lower
     * than the third element on the left side of the array.
     */

    public boolean find132pattern(int[] nums) {
        // Decreasing monotonic stack
        Stack<Integer> stack = new Stack<>();

        int k = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--)
        {
            /* 
             * If we find i to be less than k then we found our answer, as k could only exist if it would have been popped
             * off from the stack by a larger number. (The larger number being our j).
             */

            if(nums[i] < k) return true;

            // If we find a number greater than the top of the stack then remove it and make it our k number.
            while(!stack.isEmpty() && stack.peek() < nums[i])
                k = stack.pop();

            stack.push(nums[i]);
        }

        return false;
    }

    /*
     * A slower simpler approach. Keep a track of the lowest value on the left of the current index, that is our first number. Now if the current index is the second
     * number then we need to find the greatest smaller number to it's right, that will be the third number. We can either use binary search or just a treeset as
     * I have done below.
     * 
     * T: (nlogn), S: O(n)
     */

    /* public boolean find132pattern(int[] nums) {
        int[] greatestSmallerElementOnRight = new int[nums.length];
        TreeSet<Integer> set = new TreeSet<>();

        // Getting the greatest smaller element on the right of a index
        for(int i = nums.length - 1; i >= 0; i--)
        {
            Integer higher = set.lower(nums[i]);
            greatestSmallerElementOnRight[i] = (higher != null) ? higher : Integer.MIN_VALUE;
            set.add(nums[i]);
        }

        // Getting the smallest element on the left
        int smallestValue = Integer.MAX_VALUE;
        int[] leastSmallerElementOnLeft = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            leastSmallerElementOnLeft[i] = (smallestValue < nums[i]) ? smallestValue : Integer.MAX_VALUE;
            smallestValue = Math.min(smallestValue, nums[i]);

            // Check for pattern
            if(leastSmallerElementOnLeft[i] < greatestSmallerElementOnRight[i])
                return true;
        }

        return false;
    } */
}
