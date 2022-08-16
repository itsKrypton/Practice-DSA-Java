//https://leetcode.com/problems/count-good-numbers/

public class CountGoodNumbers {
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));
    }

    public static int countGoodNumbers(long n) {
        long even = (n + 1)/2;
        long odd = n/2;
        return (int)((helper(even, 5) * helper(odd, 4)) % 1000000007);
    }

    public static long helper(long n, long multiplier)
    {
        long count = 1;
        while(n > 0)
        {
            if((n&1) == 1) // if it's odd
            count = (count*multiplier) % 1000000007;

            multiplier = (multiplier * multiplier) % 1000000007;
            n = n>>1;
        }
        return count;
    }
}
