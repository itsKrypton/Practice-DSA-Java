import java.util.Arrays;
import java.util.Stack;

public class AmazonNextGreaterElement
{
    public static void main(String args[])
    {
        long arr[] = new long[]{2, 12, 3, 19, 21, 1};
        System.out.println(Arrays.toString(nextLargerElement(arr, arr.length)));
    }

    public static long[] nextLargerElement(long[] arr, int n)
    { 
        long[] answer = new long[n];
        Stack<Long> stack = new Stack<>();

        answer[n-1] = -1;
        stack.push(arr[n-1]);

        for(int i=n-2; i>=0; i--)
        {
            if(arr[i] < arr[i+1])
            answer[i] = arr[i+1];

            else
            {
                while(!stack.empty() && arr[i] > stack.peek())
                stack.pop();

                answer[i] = (stack.empty()) ? -1 : stack.peek();
            }
            stack.push(arr[i]);
        }

        return answer;
    } 
}