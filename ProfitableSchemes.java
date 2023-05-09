// https://leetcode.com/problems/profitable-schemes/

import java.util.Arrays;

public class ProfitableSchemes {
    final static int mod = 1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[group.length][minProfit + 1][n + 1];

        for(int i[][] : dp)
        {
            for(int j[] : i)
            Arrays.fill(j, -1);
        }

        return find(group.length - 1, n, minProfit, group, profit, dp);
    }

    public static int find(int index, int maxMembers, int minProfit, int[] group, int[] profit, int[][][] dp)
    {
        if(index < 0)
        {
            return (minProfit <= 0) ? 1 : 0;
        }

        if(maxMembers == 0)
        {
            return (minProfit <= 0) ? 1 : 0;
        }

        if(minProfit < 0) minProfit = 0;

        if(dp[index][minProfit][maxMembers] != -1)
        return dp[index][minProfit][maxMembers];

        int pick = 0;
        if(maxMembers - group[index] >= 0)
        pick = (find(index - 1, maxMembers - group[index], minProfit - profit[index], group, profit, dp))%mod;

        int dontPick = (find(index - 1, maxMembers, minProfit, group, profit, dp))%mod;

        return dp[index][minProfit][maxMembers] = (pick + dontPick)%mod;
    }
}
