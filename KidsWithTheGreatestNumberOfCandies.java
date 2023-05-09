//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int candy : candies)
        max = Math.max(max, candy);

        List<Boolean> answer = new ArrayList<>();
        for(int candy : candies)
        answer.add((candy + extraCandies) >= max);

        return answer;
    }
}
