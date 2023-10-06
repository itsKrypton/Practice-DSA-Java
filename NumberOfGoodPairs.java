// https://leetcode.com/problems/number-of-good-pairs/description/?envType=daily-question&envId=2023-10-03

//import java.util.HashMap;

public class NumberOfGoodPairs {
    // You can also just use an array of size 101 as the constraints are small enough to do that.
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];

        int goodPairs = 0;
        for(int num : nums)
            goodPairs += count[num]++;

        return goodPairs;
    }

    /* public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int goodPairs = 0;
        for(int num : nums)
        {
            if(map.containsKey(num))
                goodPairs += map.get(num);

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return goodPairs;
    } */
}
