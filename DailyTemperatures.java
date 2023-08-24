// https://leetcode.com/problems/daily-temperatures/submissions/861459423/

/*
 * Similar to the concept used in largest rectangle in the histogram. Basically, whenever we keep pushing elements in the stack as long as it's smaller than the previous
 * value. As sson as we find a value that is greater than the previous element, we start pushing out elements from the stack and update the answer array as per
 * current index - top index in the stack until the stack is empty. Do a dry run to understand.
 * 
 * T: O(2n) S: O(n)
 */

import java.util.Stack;

public class DailyTemperatures {
    /* public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++)
        {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()])
            answer[stack.peek()] = i - stack.pop();

            stack.push(i);
        }

        while(!stack.isEmpty())
        answer[stack.pop()] = 0;

        return answer;
    } */

    // Or can do it from the back of the input array.
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = temperatures.length - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()])
            stack.pop();

            answer[i] = (stack.isEmpty()) ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return answer;
    }
}
