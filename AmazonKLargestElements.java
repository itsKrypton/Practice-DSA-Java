import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class AmazonKLargestElements {
    public static void main(String args[])
    {
        int arr[] = new int[]{12,5,787,1,23};
        System.out.println(Arrays.asList(kLargest(arr, arr.length, 2)));
    }

    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        ArrayList<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //for smallest use Comparator.reverseOrder() in arguments
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++)
        {   
            pq.add(arr[i]);
            if(pq.size() > k)
            pq.poll();
        }

        while(!pq.isEmpty())
        stack.add(pq.poll());

        while(!stack.isEmpty())
        answer.add(stack.pop());
        
        return answer;
    }
}
