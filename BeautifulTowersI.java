import java.util.List;

/*
 * Brute force n^2, for optimal solution, see BeautifulTowersII.
 */

public class BeautifulTowersI {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long maxSum = Long.MIN_VALUE;
        
        for(int i = 0; i < maxHeights.size(); i++)
        {
            int minTillNow = maxHeights.get(i);
            long currentSum = maxHeights.get(i);
            
            for(int j = i - 1; j >= 0; j--)
            {
                minTillNow = Math.min(minTillNow, maxHeights.get(j));
                currentSum += minTillNow;
            }
            
            minTillNow = maxHeights.get(i);
            for(int j = i + 1; j < maxHeights.size(); j++)
            {
                minTillNow = Math.min(minTillNow, maxHeights.get(j));
                currentSum += minTillNow;
            }
            
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
