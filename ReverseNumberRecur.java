public class ReverseNumberRecur {
    public static void main(String args[])
    {
        System.out.println(withRecur(11));
    }

    public static int withRecur(int n)
    {
        if(n%10 == n)
        return n;

        int base = (int)Math.log10(n) + 1;
        return ((n%10) * (int)Math.pow(10, base - 1)) + withRecur(n/10);
    }
}
