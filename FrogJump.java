//https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

//import java.util.Arrays;

public class FrogJump {
    /* public static int frogJump(int n, int heights[]) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return find(n, heights, dp);
    } */

    // Memoization
    /* public static int find(int n, int heights[], int dp[])
    {
        if(n == 1)
        return 0;

        if(dp[n] != -1)
        return dp[n];

        int oneJump = find(n - 1, heights, dp) + Math.abs(heights[n - 1] - heights[n - 2]);
        int twoJump = Integer.MAX_VALUE;
        if(n > 2)
        twoJump = find(n - 2, heights, dp) + Math.abs(heights[n - 1] - heights[n - 3]);

        return dp[n] = Math.min(oneJump, twoJump);
    } */

    // Tabulation
    /* public static int find(int n, int heights[], int dp[])
    {
        dp[1] = 0;
        
        for(int i = 2; i <= n; i++)
        {
            int oneJump = dp[n-1] + Math.abs(heights[n - 1] - heights[n - 2]);
            int twoJump = Integer.MAX_VALUE;
            if(n > 2)
            twoJump = dp[n-2] + Math.abs(heights[n - 1] - heights[n - 3]);

            dp[n] = Math.min(oneJump, twoJump);
        }

        return dp[n];
    } */

    // Space optimized way
    public static int frogJump(int n, int heights[]) {
        int prev = 0;
        int prev2 = 0;
        
        for(int i = 2; i <= n; i++)
        {
            int oneJump = prev + Math.abs(heights[i - 1] - heights[i - 2]);
            int twoJump = Integer.MAX_VALUE;
            if(i > 2)
            twoJump = prev2 + Math.abs(heights[i - 1] - heights[i - 3]);

            int curr = Math.min(oneJump, twoJump);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}
