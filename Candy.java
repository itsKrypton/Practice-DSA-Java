public class Candy {
    // Two pass method, first make sure the current guy is more than the left guy. Next, traverse from the left and make sure the current guy is greater than the right.
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];

        // Comparing with left guy from left to right
        for(int i = 0; i < ratings.length; i++)
        {
            if(i == 0)
            {
                candies[i] = 1;
                continue;
            }

            candies[i] = (ratings[i] > ratings[i - 1]) ? candies[i - 1] + 1 : 1;
        }

        // Comparing with right guy from right to left
        int totalCandies = candies[ratings.length - 1];
        for(int i = ratings.length - 2; i >= 0; i--)
        {
            // Only update it if the current candies is not already more than the right guy
            if(ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1])
            candies[i] = candies[i + 1] + 1;

            totalCandies += candies[i];
        }

        return totalCandies;
    }

    
}
