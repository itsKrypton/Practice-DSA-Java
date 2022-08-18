//https://leetcode.com/problems/perfect-squares/

/* Will give TLE, need to learn DP */

public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(1000));
    }

    public static int numSquares(int n) {
        return helper(n, 0, Integer.MAX_VALUE);
    }

    public static int helper(int n, int currentCount, int minCount)
    {
        if(n == 0)
        {
            minCount = Math.min(minCount, currentCount);
            return minCount;
        }

        if(n < 0)
        return minCount;

        for(int i = 1; i <= Math.sqrt(n); i++)
        minCount = helper(n - (i * i), currentCount + 1, minCount);

        return minCount;
    }
}
