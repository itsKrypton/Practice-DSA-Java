// https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

//import java.util.Arrays;

public class NinjasTraining {
    /* public static int ninjaTraining(int n, int points[][]) {
        int dp[][] = new int[n][4];

        for(int[] days : dp)
        Arrays.fill(days, -1);

        return find(n, points, dp);
    } */

    //Memoization giving StackOverflow
    /* public static int find(int n, int points[][], int dp[][], int last)
    {
        if(n == 0)
        {
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 3; i++)
            {
                if(i != last)
                max = Math.max(max, points[0][i]);
            }
            return max;
        }

        if(dp[n][last] != -1)
        return dp[n][last];

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++)
        {
            if(i != last)
            {
                int activity = points[n][i] + find(n - 1, points, dp, i);
                max = Math.max(max, activity);
            }
        }

        return dp[n][last] = max;
    } */

    //Tabulation

    /* public static int find(int n, int points[][], int dp[][])
    {
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int days = 1; days < n; days++)
        {
            for(int last = 0; last < 4; last++)
            {
                int max = Integer.MIN_VALUE;
                for(int task = 0; task < 3; task++)
                {
                    if(task != last)
                    {
                        int activity = points[days][task] + dp[days-1][task];
                        max = Math.max(max, activity);
                    }
                }
                dp[days][last] = max;
            }
        }

        return dp[n - 1][3];
    } */

    //Space Optimized
    public static int ninjaTraining(int n, int points[][]) {
        int prev[] = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int days = 1; days < n; days++)
        {
            int temp[] = new int[4];
            for(int last = 0; last < 4; last++)
            {
                int max = Integer.MIN_VALUE;
                for(int task = 0; task < 3; task++)
                {
                    if(task != last)
                    {
                        int activity = points[days][task] + prev[task];
                        max = Math.max(max, activity);
                    }
                }
                temp[last] = max;
            }
            prev = temp;
        }

        return prev[3];
    }
}
