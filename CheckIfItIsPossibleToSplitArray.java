import java.util.Arrays;
import java.util.List;

// Partition DP

public class CheckIfItIsPossibleToSplitArray {
    // Memoization
    /* public boolean canSplitArray(List<Integer> nums, int m) {
        int[][] dp = new int[nums.size()][nums.size()];
        
        for(int[] i : dp)
        Arrays.fill(i, -1);
        
        int sum = 0;
        
        for(int i = 0; i < nums.size(); i++)
            sum += nums.get(i);
        
        return find(0, nums.size() - 1, m, sum, nums, dp);
    }
    
    public boolean find(int start, int end, int m, int sum, List<Integer> nums, int[][] dp)
    {
        if(start == end) return true;
        
        if(dp[start][end] != -1)
            return (dp[start][end] == 1) ? true : false;
        
        int currentSum = 0;
        for(int i = start; i < end; i++)
        {
            currentSum += nums.get(i);
            
            boolean take = false;
            if((start - i == 0 || currentSum >= m) && (end - i == 1 || sum - currentSum >= m))
            take = find(start, i, m, currentSum, nums, dp) && find(i + 1, end, m, sum - currentSum, nums, dp);
            
            if(take)
            {
                dp[start][end] = 1;
                return true;
            }
        }
        
        dp[start][end] = 0;
        return false;
    } */

    // Tabulation
    /* public boolean canSplitArray(List<Integer> nums, int m) {
        boolean[][] dp = new boolean[nums.size()][nums.size()];
        
        for(int i = 0; i < nums.size(); i++)
        dp[i][i] = true;
        
        for(int i = nums.size() - 1; i >= 0; i--)
        {
            int sum = 0;
            for(int j = i; j < nums.size(); j++)
            {
                sum += nums.get(j);

                int currentSum = 0;
                for(int k = i; k < j; k++)
                {
                    currentSum += nums.get(k);

                    boolean take = false;
                    if((i - k == 0 || currentSum >= m) && (j - k == 1 || sum - currentSum >= m))
                    take = dp[i][k] && dp[k + 1][j];

                    if(take)
                    {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        
        return dp[0][nums.size() - 1];
    } */

    // An easy way, we just need to see if we can find any two adjacent numbers addition to be greater than m because then the we can always partition it.
    public boolean canSplitArray(List<Integer> nums, int m) {
        if(nums.size() <= 2) return true;

        for(int i = 0; i < nums.size() - 1; i++)
        {
            if(nums.get(i) + nums.get(i + 1) >= m)
            return true;
        }

        return false;
    }
}
