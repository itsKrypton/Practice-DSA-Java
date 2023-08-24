// https://leetcode.com/problems/generate-parentheses/description/

import java.util.ArrayList;
import java.util.List;

/*
 * Maintain two variables storing the current left parenthesis and current right parenthesis. Add left parenthesis until it's less than total allowed parenthesis "n".
 * You can also add right parenthesis until it's less than or equal to the left parenthesis. If the length of current string reaches 2 * n then add it to the list of
 * answers.
 */

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(new StringBuilder(), 0, 0, ans, n);
        return ans;
    }

    public void generate(StringBuilder sb, int leftParenthesis, int rightParenthesis, List<String> ans, int n)
    {
        if(sb.length() == 2 * n)
        {
            ans.add(sb.toString());
            return;
        }

        // If we have not yet exhausted the total parenthesis
        if(leftParenthesis < n)
        {
            sb.append('(');
            generate(sb, leftParenthesis + 1, rightParenthesis, ans, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        // Adding right parenthesis only if we already have equal or more left parenthesis
        if(rightParenthesis < leftParenthesis)
        {
            sb.append(')');
            generate(sb, leftParenthesis, rightParenthesis + 1, ans, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
