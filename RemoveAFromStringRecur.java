public class RemoveAFromStringRecur {
    public static void main(String args[])
    {
        String s = "a";
        //System.out.println(removeA(s, 0, new StringBuilder()));
        System.out.println(removeA(s, new StringBuilder()));
    }

    //Here the original string will be mutated.
    public static String removeA(String s, StringBuilder sb)
    {
        if(s.isEmpty())
        return sb.toString();

        char ch = s.charAt(0);
        
        if(ch == 'a')
        return removeA(s.substring(1), sb);

        else
        return removeA(s.substring(1), sb.append(ch));
    }

    //In this approach we are not mutating the original string.
    /* public static String removeA(String s, int index, StringBuilder sb)
    {
        if(index == s.length())
        return sb.toString();

        char ch = s.charAt(index);
        
        if(ch == 'a')
        return removeA(s, ++index, sb);

        else
        return removeA(s, ++index, sb.append(ch));
    } */
}
