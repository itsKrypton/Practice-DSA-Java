import java.util.Arrays;

//import java.util.Arrays;

public class MaximumBagsWithFullCapacityOfRocks {
    //Greedy approach works better. We first find the difference of current rocks and max rocks a bag can carry. Then we sort it in ascending order and start maxing
    //out the bags from the lowest bag as it's cheaper to fill it to the brim. T: O(nlogn) S:O(n)
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] difference = new int[rocks.length];

        for(int i = 0; i < rocks.length; i++)
        difference[i] = capacity[i] - rocks[i];

        Arrays.sort(difference);

        int maxBags = 0;
        for(int i = 0; i < difference.length; i++)
        {
            if(additionalRocks - difference[i] >= 0)
            {
                additionalRocks -= difference[i];
                maxBags++;
            }
        }

        return maxBags;
    }


    //DP leads to memory limit exceeded
    //Memoization
    /* public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[][] dp = new int[rocks.length][additionalRocks + 1];

        for(int[] row : dp)
        Arrays.fill(row, -1);

        return find(rocks.length - 1, capacity, rocks, additionalRocks, dp);
    }

    public int find(int index, int[] capacity, int[] rocks, int additionalRocks, int[][] dp)
    {
        if(index == -1)
        return 0;

        if(dp[index][additionalRocks] != -1)
        return dp[index][additionalRocks];

        int take = 0;
        if(capacity[index] - rocks[index] <= additionalRocks)
        take = 1 + find(index - 1, capacity, rocks, additionalRocks - (capacity[index] - rocks[index]), dp);

        int notTake = find(index - 1, capacity, rocks, additionalRocks, dp);

        return dp[index][additionalRocks] =  Math.max(take, notTake);
    } */

    //Tabulation
    /* public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[][] dp = new int[rocks.length + 1][additionalRocks + 1];

        return find(capacity, rocks, additionalRocks, dp);
    }

    public int find(int[] capacity, int[] rocks, int additionalRocks, int[][] dp)
    {
        for(int i = 0; i < rocks.length; i++)
        {
            for(int j = 0; j <= additionalRocks; j++)
            {
                int take = 0;
                if(capacity[i] - rocks[i] <= j)
                take = 1 + dp[i][j - (capacity[i] - rocks[i])];
        
                int notTake = dp[i][j];
        
                dp[i + 1][j] =  Math.max(take, notTake);
            }
        }

        return dp[rocks.length][additionalRocks];
    } */
}
