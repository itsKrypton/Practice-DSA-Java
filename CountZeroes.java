public class CountZeroes {
    public static void main(String args[])
    {
        int number = 10045670;
        if(number == 0)
        System.out.println(1);

        else
        System.out.println(count(number, 0));
    }

    public static int count(int n, int c)
    {
        if(n == 0)
        return c;

        if(n%10 == 0)
        return count(n/10, ++c);

        else 
        return count(n/10, c);
    }
}
