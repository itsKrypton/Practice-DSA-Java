//https://leetcode.com/problems/beautiful-towers-ii/

import java.util.List;
import java.util.Stack;

/* 
 * To make a particular index as peak of the mountain array, we can make the values to the left equal to current value until we find a value less than the current value,
 * at which point, we make it equal to that value for all the values to it's left. Use the logic from next smaller value using stack on the left and right.
 */

public class BeautifulTowersII {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        Stack<Integer> stack = new Stack<>();
        long[] leftSum = new long[maxHeights.size()];
        
        // Find the max sum till the index 1
        for(int i = 0; i < maxHeights.size(); i++)
        {
            long currentNumber = maxHeights.get(i);
            
            // Find the index on the left whose value is less than the current number
            while(!stack.isEmpty() && currentNumber < maxHeights.get(stack.peek()))
                stack.pop();
            
            // If we found no index smaller on the left then we can make current index and all previous indexes same as current number
            if(stack.isEmpty())
                leftSum[i] = currentNumber * (i + 1);
            
            // Else make all the indexes until the previous smaller index equal to current number and add the sum of the previous smaller
            // index
            else
            {
                leftSum[i] = currentNumber * (i - stack.peek());
                leftSum[i] += leftSum[stack.peek()];
            }
            
            // Add the current index to the stack
            stack.push(i);
        }
        
        // Now do the same from the right side by finding the right smaller indexes and calculating the sum accordingly.
        stack.clear();
        long[] rightSum = new long[maxHeights.size()];
        long maxAnswer = Integer.MIN_VALUE;
        for(int i = maxHeights.size() - 1; i >= 0; i--)
        {
            long currentNumber = maxHeights.get(i);
            
            while(!stack.isEmpty() && currentNumber < maxHeights.get(stack.peek()))
                stack.pop();
            
            if(stack.isEmpty())
                rightSum[i] = currentNumber * (maxHeights.size() - i);
            
            else
            {
                rightSum[i] = currentNumber * (stack.peek() - i);
                rightSum[i] += rightSum[stack.peek()];
            }
            
            stack.push(i);

            // Find the max sum possible for the current index and update the max answer so far.
            long sumAtCurrentIndex = leftSum[i] + rightSum[i] - maxHeights.get(i);
            maxAnswer = Math.max(maxAnswer, sumAtCurrentIndex);
        }
        
        return maxAnswer;
    }
}