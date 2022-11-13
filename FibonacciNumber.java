//import java.util.Arrays;

public class FibonacciNumber {
    
    //Normal recursive solution, takes O(2^n) time and O(n) space (Stack space)
    /* public int fib(int n) {
        if(n <= 1)
        return n;

        return fib(n-1) + fib(n-2);
    } */

    // Memoization solution, takes O(n) time and O(n) + O(n) space (dp array + stack space).
    /* public int fib(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return find(n, dp);
    }

    // Tabulation solution, takes O(n) time and O(1) space
    public int find(int n, int[] dp)
    {
        if(n <= 1)
        return n;

        if(dp[n] != -1)
        return dp[n];

        return dp[n] = find(n-1, dp) + find(n-2, dp); 
    } */

    // Tabulation solution, takes O(n) time and O(1) space

    public int fib(int n) {
        if(n <= 1)
        return n;

        int prev2 = 0;
        int prev = 1;

        for(int i = 2; i <= n; i++)
        {
            int currentI = prev2 + prev;
            prev2 = prev;
            prev = currentI;
        }

        return prev;
    }

    // You can also solve the recurrence relation via Akra Baazi formula to find the formula for O(1) time and space.
}
