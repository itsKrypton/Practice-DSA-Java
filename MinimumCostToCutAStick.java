// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;

public class MinimumCostToCutAStick {

    // Memoization
    /* public int minCost(int n, int[] cuts) {
        ArrayList<Integer> modifiedCuts = new ArrayList<>();
        
        modifiedCuts.add(0);
        for(int i = 0; i < cuts.length; i++)
        modifiedCuts.add(i + 1, cuts[i]);
        modifiedCuts.add(n);

        Collections.sort(modifiedCuts);

        int dp[][] = new int[modifiedCuts.size()][modifiedCuts.size()];

        for(int[] i : dp)
        Arrays.fill(i, -1);

        return find(1, cuts.length, modifiedCuts, dp);
    }

    public static int find(int i, int j, ArrayList<Integer> cuts, int[][] dp)
    {
        if(i > j)
        return 0;

        if(dp[i][j] != -1)
        return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++)
        {
            int ans = cuts.get(j + 1) - cuts.get(i - 1) + find(i, k - 1, cuts, dp) + find(k + 1, j, cuts, dp);
            min = Math.min(min, ans);
        }

        return dp[i][j] = min;
    } */

    //Tabulation
    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> modifiedCuts = new ArrayList<>();
        
        modifiedCuts.add(0);
        for(int i = 0; i < cuts.length; i++)
        modifiedCuts.add(i + 1, cuts[i]);
        modifiedCuts.add(n);

        Collections.sort(modifiedCuts);

        int dp[][] = new int[modifiedCuts.size()][modifiedCuts.size()];

        for(int i = cuts.length; i >= 1; i--)
        {
            for(int j = 1; j <= cuts.length; j++)
            {
                if(i > j)
                continue;

                int min = Integer.MAX_VALUE;
                for(int k = i; k <= j; k++)
                {
                    int ans = modifiedCuts.get(j + 1) - modifiedCuts.get(i - 1) + dp[i][k - 1] + dp[k + 1][j];
                    min = Math.min(min, ans);
                }
        
                dp[i][j] = min;
            }
        }

        return dp[1][cuts.length];
    }
}
