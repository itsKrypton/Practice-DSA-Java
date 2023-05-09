//https://leetcode.com/problems/last-stone-weight/

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones)
        queue.add(stone);

        while(queue.size() != 1 && !queue.isEmpty())
        queue.add(queue.remove() - queue.remove());

        return (queue.isEmpty()) ? 0 : queue.remove();
    }
}
