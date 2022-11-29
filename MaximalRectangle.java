// https://leetcode.com/problems/maximal-rectangle/description/

/*
 * This problem is similar to Largest Rectangle In Histogram. For every row we keep modifying the height of the histogram and find the max area at every row.
 */

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int currentHeight[] = new int[matrix[0].length];
        for(char[] row : matrix)
        {
            for(int i = 0; i < row.length; i++)
            {
                if((row[i] - '0') < currentHeight[i])
                currentHeight[i] = 0;

                else
                currentHeight[i]++;
            }
            max = Math.max(max, largestRectangleArea(currentHeight));
        }

        return max;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max = 0;

        for(int i = 0; i <= heights.length; i++)
        {
            while(!st.isEmpty() && (i == heights.length || heights[st.peek()] >= heights[i]))
            {
                int height = heights[st.pop()];
                int width = 0;

                if(st.isEmpty())
                width = i;

                else
                width = i - st.peek() - 1;

                max = Math.max(max, width * height);
            }
            st.push(i);
        }

        return max;
    }
}
