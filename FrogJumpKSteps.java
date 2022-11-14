//https://atcoder.jp/contests/dp/tasks/dp_b

import java.util.*;

public class FrogJumpKSteps
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int heights[] = new int[n];

        for(int i=0; i<n; i++)
        heights[i] = in.nextInt();

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        System.out.println(find(n, heights, k, dp));
        in.close();
    }

    /* public static int find(int n, int heights[], int k, int dp[])
    {
        if(n == 1)
        return 0;

        if(dp[n] != -1)
        return dp[n];

        int minEnergy = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++)
        {
            if(n-i >= 1)
            minEnergy = Math.min(minEnergy, find(n - i, heights, k, dp) + Math.abs(heights[n - 1] - heights[n - 1 - i]));
        }

        return dp[n] = minEnergy;
    } */

    //Tabulation approach
    public static int find(int n, int heights[], int k, int dp[])
    {
        dp[1] = 0;

        for(int j=2; j<=n; j++)
        {
            int minEnergy = Integer.MAX_VALUE;
            for(int i=1; i<=k; i++)
            {
                if(j-i >= 1)
                minEnergy = Math.min(minEnergy, dp[j-i] + Math.abs(heights[j - 1] - heights[j - 1 - i]));
            }

            dp[j] = minEnergy;
        }

        return dp[n];
    }
}