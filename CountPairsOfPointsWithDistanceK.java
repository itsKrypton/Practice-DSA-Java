import java.util.HashMap;
import java.util.List;

public class CountPairsOfPointsWithDistanceK {

    /*
     * For two points (x1, y1) and (x2, y2), we need to see if x1 ^ x2 + y1 ^ y2 = k or not. We know (x1, y1), but how do we check if we have come across (x2, y2)
     * before? Let's assume,
     * 
     * (x1 ^ x2) = p, then 
     * (y1 ^ y2) = k - p
     * 
     * We can also write it as,
     * 
     * (x1 ^ p) = x2
     * and (y1 ^ (k - p)) = y2 (by using XOR properties)
     * 
     * We know k has a limit of 100, thus our p can have values from 0 to 100. So just find p via brute force.
     */

    public int countPairs(List<List<Integer>> coordinates, int k) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        int numberOfPairs = 0;
        for(List<Integer> coord : coordinates)
        {
            int x1 = coord.get(0);
            int y1 = coord.get(1);

            for(int p = 0; p <= 100; p++)
            {
                // Find x2 and y2 as per the equation above
                int x2 = (x1 ^ p);
                int y2 = (y1 ^ (k - p));

                // Check whether this point exists in the hashmap.
                if(map.containsKey(x2) && map.get(x2).containsKey(y2))
                    numberOfPairs += map.get(x2).get(y2);
            }

            // Add current point in the hashmap
            map.computeIfAbsent(x1, x -> new HashMap<>()).put(y1, map.get(x1).getOrDefault(y1, 0) + 1);

            // The line above is equivalent to the two lines below
            /* map.putIfAbsent(x1, new HashMap<>());
            map.get(x1).put(y1, map.get(x1).getOrDefault(y1, 0) + 1); */
        }

        return numberOfPairs;
    }
}
