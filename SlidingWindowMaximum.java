// https://leetcode.com/problems/sliding-window-maximum/

/*
 * Just maintain a monotonic queue of numbers in descending order and store the indexes if numbers. The queue should only have at most k elements
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[nums.length - k + 1];

        for(int i = 0; i < nums.length; i++)
        {
            if(!deque.isEmpty() && deque.peekFirst() == i - k)
            deque.removeFirst();

            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
            deque.removeLast();

            deque.add(i);

            if(i >= k - 1)
            answer[i - k + 1] = nums[deque.peekFirst()];
        }

        return answer;
    }
}
