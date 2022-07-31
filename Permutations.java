public class Permutations {
    public static void main(String[] args) {
        String s = "abc";
        permutations("", s);
    }

    public static void permutations(String pString, String uString)
    {
        if(uString.isEmpty())
        {
            System.out.println(pString);
            return;
        }

        char ch = uString.charAt(0);

        for(int i=0; i<=pString.length(); i++)
        {
            String start = pString.substring(0, i); 
            String end = pString.substring(i, pString.length()); 
            permutations(start + ch + end, uString.substring(1));
        }
    }
}
