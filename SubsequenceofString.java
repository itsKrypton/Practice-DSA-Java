public class SubsequenceofString {
    public static void main(String args[])
    {
        String s = "abc";
        subsequence("", s);
    }

    public static void subsequence(String processedString, String unprocessedString)
    {
        if(unprocessedString.isEmpty() && processedString.length() > 0)
        {
            System.out.println(processedString.toString());
            return;
        }

        else if(unprocessedString.isEmpty() && processedString.length() == 0)
        return;

        subsequence(processedString + unprocessedString.charAt(0), unprocessedString.substring(1)); // we take the first character from ustring in here
        subsequence(processedString, unprocessedString.substring(1)); // we skip the character in here
    }
}
