// https://leetcode.com/problems/smallest-number-in-infinite-set/

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestNumberInInfiniteSet {
    public int smallestNumber;
    public PriorityQueue<Integer> queue;
    public HashSet<Integer> set;

    public SmallestNumberInInfiniteSet() {
        this.smallestNumber = 1;
        this.queue = new PriorityQueue<>();
        this.set = new HashSet<>();
    }
    
    public int popSmallest() {
        if (!this.queue.isEmpty())
        {
            this.set.remove(this.queue.peek());
            return this.queue.remove();
        }
        return this.smallestNumber++;
    }
    
    public void addBack(int num) {
        if(num < this.smallestNumber && this.set.add(num)) this.queue.add(num);
    }
}
