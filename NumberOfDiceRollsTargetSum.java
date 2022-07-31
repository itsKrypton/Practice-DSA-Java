//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

/* TLE right now need to learn DP to make it efficient */

public class NumberOfDiceRollsTargetSum {
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(1, 1, 1));
    }

    public static int numRollsToTarget(int n, int k, int target) {
        int count = 0;

        if(target == 0)
        {
            count++;
            return count % (int)(Math.pow(10, 9) + 7);
        }

        while(n > 0) // This represents the number of dice you can throw
        {
            for(int i = 1; i <= k && i<=target; i++) // This represents the number of faces of dice available at each throw
            count += numRollsToTarget(n - 1, k, target - i);

            break;
        }

        return count;
    }
}
