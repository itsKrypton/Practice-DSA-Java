//https://leetcode.com/problems/minimum-time-to-complete-trips/description/

public class MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        long low = 1, max = Long.MAX_VALUE;
        while(low < max)
        {
            long mid = low + (max - low) / 2;

            long currentTrips = 0;
            for(int i : time)
            {
                currentTrips += mid/i;

                if(currentTrips >= totalTrips)
                break;
            }

            if(currentTrips >= totalTrips)
            max = mid;

            else
            low = mid + 1;
        }
        return low;
    }
}
