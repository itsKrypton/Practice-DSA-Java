// https://leetcode.com/problems/frog-jump/description/

//import java.util.Arrays;
import java.util.HashMap;

/*
 * For every index, jump to lastJump - 1, lastJump, or lastJump + 1 stone. Check if we can reach the last index, if yes, return true.
 */

public class FrogJumpLeetcode {
    // Memoization
    /* public static boolean canCross(int[] stones) {
        int[][] dp = new int[stones.length][stones.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < stones.length; i++)
        map.put(stones[i], i);

        for(int[] i : dp)
        Arrays.fill(i, -1);

        if(stones[1] == 1)
        return find(1, 1, stones, map, dp);

        return false;
    }

    public static boolean find(int index, int lastJump, int[] stones, HashMap<Integer, Integer> map, int[][] dp)
    {
        if(index == stones.length - 1)
        {
            dp[index][lastJump] = 1;
            return true;
        }

        if(dp[index][lastJump] != -1)
        return (dp[index][lastJump] == 1) ? true : false; 

        for(int currentJump = (lastJump == 1) ? lastJump : lastJump - 1; currentJump <= lastJump + 1; currentJump++)
        {
            if(map.containsKey(stones[index] + currentJump))
            {
                if(find(map.get(stones[index] + currentJump), currentJump, stones, map, dp))
                {
                    dp[index][lastJump] = 1;
                    return true;
                }
            }
        }

        dp[index][lastJump] = 0;
        return false;
    } */

    // Tabulation
    public boolean canCross(int[] stones) {
        boolean[][] dp = new boolean[stones.length][stones.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < stones.length; i++)
        map.put(stones[i], i);

        if(stones[1] == 1)
        {
            for(int j = 1; j < stones.length; j++)
            dp[stones.length - 1][j] = true;

            for(int i = stones.length - 2; i >= 1; i--)
            {
                for(int j = i; j >= 1; j--)
                {
                    for(int currentJump = (j == 1) ? j : j - 1; currentJump <= j + 1; currentJump++)
                    {
                        if(map.containsKey(stones[i] + currentJump))
                        {
                            if(dp[map.get(stones[i] + currentJump)][currentJump])
                            dp[i][j] = true;
                        }
                    }
                }
            }

            return dp[1][1];
        }

        return false;
    }
}
