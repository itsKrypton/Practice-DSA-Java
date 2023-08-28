import java.util.List;
import java.util.PriorityQueue;

public class MinimumOperationsToFormSubsequenceTarget {
    public int minOperations(List<Integer> nums, int target) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        
        // Insert elements into pQueue and find the sum
        long sum = 0;
        for(int num : nums)
        {
            sum += num;
            pQueue.add(num);
        }

        // We can never reach the target
        if(sum < target) return -1;

        // Calculate the operations
        int operations = 0;
        while(target > 0)
        {
            int currentElement = pQueue.remove();
            sum -= currentElement;

            if(currentElement <= target)
            target -= currentElement;

            // If the currentElement is greater than the target and the sum of the rest of the elements don't make up to the target then split the currentElement
            else if(sum < target)
            {
                operations++;
                sum += currentElement;
                pQueue.add(currentElement / 2);
                pQueue.add(currentElement / 2);
            }
        }

        return operations;
    }
}