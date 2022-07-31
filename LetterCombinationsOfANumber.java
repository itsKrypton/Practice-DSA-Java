// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfANumber {
    public static void main(String args[])
    {
        System.out.println(letterCombinations("9"));
    }

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
        return new ArrayList<>();
        
        return helper("", digits);
    }

    public static List<String> helper(String pString, String uString) // uString = 
    {
        List<String> answers = new ArrayList<>();

        if(uString.isEmpty())
        {
            answers.add(pString);
            return answers;
        }

        int digit = uString.charAt(0) - '0';

        if(digit < 7)
        for(int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) 
        {
            char ch = (char)('a' + i);
            answers.addAll(helper(pString + ch, uString.substring(1)));
        }

        else if(digit == 7)
        for(int i = (digit - 2) * 3; i <= (digit - 1) * 3; i++) 
        {
            char ch = (char)('a' + i);
            answers.addAll(helper(pString + ch, uString.substring(1)));
        }

        else if(digit == 8)
        for(int i = (digit - 2) * 3 + 1; i <= (digit - 1) * 3; i++) 
        {
            char ch = (char)('a' + i);
            answers.addAll(helper(pString + ch, uString.substring(1)));
        }

        else if(digit == 9)
        for(int i = (digit - 2) * 3 + 1; i <= (digit - 1) * 3 + 1; i++) 
        {
            char ch = (char)('a' + i);
            answers.addAll(helper(pString + ch, uString.substring(1)));
        }

        return answers;
    }
}
