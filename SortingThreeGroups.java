//import java.util.Arrays;
import java.util.List;

/*
 * We need the next index values to be greater than or equal to the current index value, thus, we can have current values from 1 to 3 and next ones have to be greater
 * than whatever current value we choose. Whenever we change the value from the current value of array, we add a plus 1. Simply return the minimum of steps.
 */

public class SortingThreeGroups {
    // Memoization
    /* public int minimumOperations(List<Integer> nums) {
        int[][] dp = new int[nums.size() + 1][4];

        for(int[] i : dp)
        Arrays.fill(i, Integer.MAX_VALUE);

        return find(0, 1, nums, dp);
    }
    
    public int find(int index, int prev, List<Integer> nums, int[][] dp)
    {
        if(index == nums.size())
        return 0;

        if(dp[index][prev] != Integer.MAX_VALUE)
        return dp[index][prev];

        int operations = (int)1e9;
        for(int i = prev; i <= 3; i++)
        {
            if(i == nums.get(index))
            operations = Math.min(operations, find(index + 1, i, nums, dp));

            else
            operations = Math.min(operations, 1 + find(index + 1, i, nums, dp));
        }

        return dp[index][prev] = operations;
    } */

    // Tabulation
    /* public int minimumOperations(List<Integer> nums) {
        int[][] dp = new int[nums.size() + 1][4];

        for(int i = nums.size() - 1; i >= 0; i--)
        {
            for(int j = 3; j >= 1; j--)
            {
                int operations = (int)1e9;
                for(int k = j; k <= 3; k++)
                {
                    if(k == nums.get(i))
                    operations = Math.min(operations, dp[i + 1][k]);

                    else
                    operations = Math.min(operations, 1 + dp[i + 1][k]);
                }

                dp[i][j] = operations;
            }
        }

        return dp[0][1];
    } */

    // Space optimized
    public int minimumOperations(List<Integer> nums) {
        int[] next = new int[4];

        for(int i = nums.size() - 1; i >= 0; i--)
        {
            int[] temp = new int[next.length];
            for(int j = 3; j >= 1; j--)
            {
                int operations = (int)1e9;
                for(int k = j; k <= 3; k++)
                {
                    if(k == nums.get(i))
                    operations = Math.min(operations, next[k]);

                    else
                    operations = Math.min(operations, 1 + next[k]);
                }

                temp[j] = operations;
            }
            next = temp;
        }

        return next[1];
    }
}
