import java.util.Stack;

public class AmazonStockSpanProblem
{
    public static int[] calculateSpan(int price[], int n)
    {
        int answer[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        answer[0] = 1;
        stack.push(0);

        for(int i=1;i<n;i++)
        {
            while(!stack.empty() && price[stack.peek()] <= price[i])
            stack.pop();

            answer[i] = (stack.empty()) ? (i+1) : (i - stack.peek());
            stack.push(i);
        }

        return answer;
    }
}