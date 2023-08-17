// https://leetcode.com/problems/valid-palindrome/description/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;

        while(low < high)
        {
            char chLow = s.charAt(low);
            char chHigh = s.charAt(high);

            if(!Character.isLetterOrDigit(chLow))
            low++;

            else if(!Character.isLetterOrDigit(chHigh))
            high--;

            else if(Character.toLowerCase(chLow) != Character.toLowerCase(chHigh))
            return false;

            else 
            {
                low++;
                high--;
            }
        }

        return true;
    }
}
