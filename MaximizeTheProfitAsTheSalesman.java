// https://leetcode.com/problems/maximize-the-profit-as-the-salesman/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * T: O(n + offers.length)
 * S: O(n + offers.length)
 */

public class MaximizeTheProfitAsTheSalesman {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int[] dp = new int[n];
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        // For quick lookup of all the offers from a starting point.
        for(List<Integer> offer : offers)
        {
            List<int[]> currentList = map.getOrDefault(offer.get(0), new ArrayList<>());
            currentList.add(new int[]{offer.get(1), offer.get(2)});
            map.put(offer.get(0), currentList);
        }

        // Traverse through all the houses one by one
        for(int i = 0; i < n; i++)
        {
            // For every house, choose the max profit between current profit and profit till last house
            if(i > 0)
            dp[i] = Math.max(dp[i], dp[i - 1]);

            // Get all the offers from the current house and set the profit of end houses that is, max profit till last house + profit of buying houses from current house
            // end house.
            if(map.containsKey(i))
            {
                for(int[] offer : map.get(i))
                dp[offer[0]] = (i == 0) ? Math.max(dp[offer[0]], offer[1]) : Math.max(dp[offer[0]], dp[i - 1] + offer[1]);
            }
        }

        return dp[n - 1];
    }
}
