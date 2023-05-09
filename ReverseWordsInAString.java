// https://leetcode.com/problems/reverse-words-in-a-string/

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        int start = -1, end = -1;
        StringBuilder sb = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--)
        {
            if(!Character.isWhitespace(s.charAt(i)))
            {
                end = i;
                while(i >= 0)
                {
                    if(i == 0 || Character.isWhitespace(s.charAt(i - 1)))
                    {
                        start = i;
                        break;
                    }
                }

                if(start != -1 && end != -1)
                {
                    sb.append(s.substring(start, end + 1));
                    start = -1;
                    end = -1;
                }
            }
        }

        return sb.toString();
    }
}
