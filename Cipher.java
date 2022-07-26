// time pass problem

public class Cipher {
    public static void main(String args[])
    {
        String test = "abcdef";
        System.out.println(cipher(test, 23));
    }

    public static String cipher(String text, int key)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<text.length(); i++)
        {
            char ch = text.charAt(i);
            sb.append((char)((((int)ch - 97 + key) % 26) + 97));
        }
        return sb.toString();
    }
}
