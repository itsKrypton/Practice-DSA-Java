// https://leetcode.com/problems/gas-station/description/

// First we add up all the gas and cost and check if the total cost is more than the total gas, in that case we will never reach the initial gas station again. Thus,
// we can return -1.

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;

        for(int i = 0; i < gas.length; i++)
        {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalCost > totalGas) return -1;

        int remainingGas = 0, start = 0;

        for(int i = 0; i < gas.length; i++)
        {
            remainingGas = remainingGas + (gas[i] - cost[i]);

            if(remainingGas < 0)
            {
                start = i+1;
                remainingGas = 0;
            }
        }

        return start;
    }
}
