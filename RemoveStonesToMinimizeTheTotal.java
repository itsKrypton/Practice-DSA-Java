import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : piles)
        queue.add(i);

        while(k-- > 0)
        {
            int num = queue.poll();
            num = (int)Math.ceil((double)num/2);
            queue.add(num);
        }

        int sum = 0;
        while(!queue.isEmpty())
        sum += queue.poll();

        return sum;

    }
}
