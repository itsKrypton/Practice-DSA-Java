public class RemovingStartsString {
    public String removeStars(String s) {
        StringBuilder pString = new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);

            if(ch == '*')
            pString.deleteCharAt(pString.length() - 1);

            else
            pString.append(ch);
        }

        return pString.toString();
    }

    public static String helper(StringBuilder pString, String uString)
    {
        if(uString.isEmpty())
        return pString.toString();

        char ch = uString.charAt(0);

        if(ch == '*')
        return helper(pString.deleteCharAt(pString.length() - 1), uString.substring(1));

        return helper(pString.append(ch), uString.substring(1));
    }
}
