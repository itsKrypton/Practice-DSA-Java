import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedIndex = 0;

        for(int pushedValue : pushed)
        {
            stack.push(pushedValue);

            // Ideally we would check if poppedIndex < popped.length but we know that popped.length == pushed.length thus when poppedIndex == popped.length, stack will always be empty.
            while(!stack.isEmpty() && stack.peek() == popped[poppedIndex])
            {
                stack.pop();
                poppedIndex++;
            }
        }

        return stack.isEmpty();
    }
}
