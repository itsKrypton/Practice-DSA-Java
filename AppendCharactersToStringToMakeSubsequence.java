public class AppendCharactersToStringToMakeSubsequence {
    public int appendCharacters(String s, String t) {
        int n1 = 0;
        int n2 = 0;

        while(n1 < s.length() || n2 < t.length())
        {
            if(s.charAt(n1) == t.charAt(n2))
            {
                n1++;
                n2++;
            }

            else
            n1++;
        }

        if(n2 == t.length())
        return 0;

        else
        return t.length() - n2 + 1;
    }
}
