import java.util.Stack;

// You can find the leftSmall and rightSmall array using the stack and then find the area of the rectangle that way but this would have T: O(4n) and S: O(3n)

public class LargestRectangleInHistogram {
    /* public int largestRectangleArea(int[] heights) {
        int[] leftSmall = new int[heights.length];
        int[] rightSmall = new int[heights.length];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < heights.length; i++)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            st.pop();

            if(st.isEmpty())
            leftSmall[i] = 0;

            else
            leftSmall[i] = st.peek() + 1;

            st.push(i);
        }

        while(!st.isEmpty())
        st.pop();

        int max = Integer.MIN_VALUE;
        for(int i = heights.length - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            st.pop();

            if(st.isEmpty())
            rightSmall[i] = heights.length - 1;

            else
            rightSmall[i] = st.peek() - 1;

            st.push(i);

            max = Math.max(max, (rightSmall[i] - leftSmall[i] + 1) * heights[i]);
        }

        return max;
    } */
    
    // This is an T: O(n) approach with S: O(n)
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
