// https://leetcode.com/problems/maximum-number-of-alloys/description/

/*
 * Using binary search, we can figure out the maximum alloys we can make between 0 to ie9. Let's say for total alloys x, figure out the cost to make those many allows 
 * with the given machines. If we find any machine capable of making x alloys within the given budget than try to make more alloys via binary search. Else, reduce the 
 * number of alloys that we are trying to make.
 */

import java.util.List;

public class MaximumNumberOfAlloys {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        long lowAlloys = 0, highAlloys = (long)1e9;

        while(lowAlloys <= highAlloys)
        {
            long mid = lowAlloys + (highAlloys - lowAlloys) / 2;

            if(canMakeGivenAlloys(mid, budget, composition, stock, cost))
            lowAlloys = mid + 1;

            else
            highAlloys = mid - 1;
        }

        return (int)highAlloys;
    }

    public boolean canMakeGivenAlloys(long numberOfAlloys, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost)
    {
        for(List<Integer> machine : composition)
        {
            long currentCost = 0;
            for(int requiredMetal = 0; requiredMetal < machine.size(); requiredMetal++)
            {
                long totalMetal = machine.get(requiredMetal) * numberOfAlloys;

                if(totalMetal > stock.get(requiredMetal))
                {
                    long extraRequiredMetal = totalMetal - stock.get(requiredMetal);
                    currentCost += extraRequiredMetal * cost.get(requiredMetal);
                }
            }

            if(currentCost <= budget) return true;
        }

        return false;
    }
}
