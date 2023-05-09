// https://leetcode.com/problems/koko-eating-bananas/description/

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Integer.MAX_VALUE;

        while(low < high)
        {
            int mid = low + (high - low) / 2;

            int currentHours = 0;
            for(int i : piles)
            {
                currentHours += Math.ceil((double)i / mid);
                if(currentHours > h) break;
            }

            if(currentHours > h)
            low = mid + 1;

            else
            high = mid;
        }

        return high;
    }
}
