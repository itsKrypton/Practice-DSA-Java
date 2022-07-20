//https://leetcode.com/problems/count-primes/submissions/

/*
 * In this problem, we are first using boolean array to eliminate all multiples of prime numbers and then we only print the numbers whose value in array is false
 * Space = O(n)
 * Time = O(N * log(log n))
 * Also called Sieve of Eratosthenes
 */

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n+1];

        for(int i = 2; i*i <= n; i++)
        {
            if(!primes[i])
            {
                for(int j = i*2; j <= n; j+=i)
                primes[j] = true;
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++)
        {
            if(!primes[i])
            count++;
        }

        return count;
    }
}
