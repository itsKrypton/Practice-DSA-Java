import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String args[])
    {
        String tokens[] = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
    
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++)
        {
            if(tokens[i].equals("+"))
            stack.push(stack.pop() + stack.pop());

            else if(tokens[i].equals("*"))
            stack.push(stack.pop() * stack.pop());

            else if(tokens[i].equals("/"))
            {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }

            else if(tokens[i].equals("-"))
            {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }

            else
            stack.push(Integer.parseInt(tokens[i]));
        }

        return stack.pop();
    }
}
