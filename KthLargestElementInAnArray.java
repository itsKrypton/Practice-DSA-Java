//import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    /* public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++)
        {
            if(pQueue.size() < k)
            pQueue.add(nums[i]);

            else if(nums[i] > pQueue.peek())
            {
                pQueue.remove();
                pQueue.add(nums[i]);
            }
        }

        return pQueue.peek();
    } */

    // QuickSelect method
    /*
     * Using quicksort algorithm, at every pivot, we will check if the given k is to the right or to the left and accordingly we will only sort that part.
     */
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 6));
    }
    public static int findKthLargest(int[] nums, int k) {
        // Index of kth largest element.
        k = nums.length - k;

        return find(0, nums.length - 1, nums, k);
    }

    public static int find(int low, int high, int[] nums, int k)
    {
        int start = low;
        int end = high;
        int pivot = nums[start];

        while(start < end)
        {
            while(nums[start] <= pivot && start <= high - 1)
            start++;

            while(nums[end] > pivot && end >= low + 1)
            end--;

            if(start < end)
            {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }

        // Placing the pivot to it's correct position
        int temp = nums[low];
        nums[low] = nums[end];
        nums[end] = temp;

        if(end < k)
        return find(end + 1, high, nums, k);

        else if(end > k)
        return find(low, end - 1, nums, k);

        else
        return pivot;
    }
}
