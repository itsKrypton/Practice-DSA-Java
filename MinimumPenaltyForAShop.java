public class MinimumPenaltyForAShop {
    // Find the prefix and suffix penalties, add it and find the minimum penalty.
    // T: O(2n) S: O(n)
    /* public int bestClosingTime(String customers) {
        int[] lossAtEveryCustomer = new int[customers.length() + 1];

        // Calculating loss from left before the current customer
        int numberOfN = 0;
        for(int i = 0; i <= customers.length(); i++)
        lossAtEveryCustomer[i] = (i < customers.length() && customers.charAt(i) == 'N') ? numberOfN++ : numberOfN;

        // Calculating loss from right including the current customer and finding the minimum loss
        int numberOfY = 0, minLoss = lossAtEveryCustomer[customers.length()], optimalClosingTime = customers.length();
        for(int i = customers.length() - 1; i >= 0; i--)
        {
            if(customers.charAt(i) == 'Y')
            numberOfY++;

            lossAtEveryCustomer[i] += numberOfY;

            if(lossAtEveryCustomer[i] <= minLoss)
            {
                minLoss = lossAtEveryCustomer[i];
                optimalClosingTime = i;
            }
        }

        return optimalClosingTime;
    } */

    // We can optimize it by removing the array as we can find the total N's in one pass and keep reducing the n's and calculate y's at the same time while traversing
    // from the back
    // T: O(2n) S: O(1)
    public int bestClosingTime(String customers) {
        // Calculating loss from left before the current customer
        int numberOfN = 0;
        for(int i = 0; i < customers.length(); i++)
        {
            if(customers.charAt(i) == 'N')
            numberOfN++;
        }

        // Calculating loss from right including the current customer and finding the minimum loss
        int numberOfY = 0, minLoss = numberOfN, optimalClosingTime = customers.length();
        for(int i = customers.length() - 1; i >= 0; i--)
        {
            if(customers.charAt(i) == 'Y')
            numberOfY++;

            else
            numberOfN--;

            if(numberOfN + numberOfY <= minLoss)
            {
                minLoss = numberOfN + numberOfY;
                optimalClosingTime = i;
            }
        }

        return optimalClosingTime;
    }

    // We maintain a maxScore which tells us the maxScore and at which time we attained that score. Our answer will be the time of best score + 1.
    // T: O(n) S: O(1)
    /* public int bestClosingTime(String customers) {
        int currentScore = 0, maxScore = 0, bestTime = -1;

        for(int i = 0; i < customers.length(); i++)
        {
            currentScore += (customers.charAt(i) == 'Y') ? 1 : -1;

            if(currentScore > maxScore)
            {
                maxScore = currentScore;
                bestTime = i;
            }
        }

        // Because we are getting the best score at ith time, hence, we close the store at ith + 1 time.
        return bestTime + 1;
    } */
}
