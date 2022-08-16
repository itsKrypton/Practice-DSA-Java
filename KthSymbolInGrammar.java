public class KthSymbolInGrammar {
    public static void main(String[] args) {
        System.out.println(kthGrammar(2, 2));
    }

    public static int kthGrammar(int n, int k) 
    {
        return helper(k, new StringBuilder("0"));
    }

    //Gives TLE
    public static int helper(int k, StringBuilder sb)
    {
        if(sb.length() >= k)
        return sb.charAt(k-1) - '0';

        int currentLength = sb.length();
        for(int i = 0; i < currentLength; i++)
        {
            if(sb.charAt(i) == '0')
            sb.append('1');

            else
            sb.append('0');
        }

        return helper(k, sb);
    }
}
