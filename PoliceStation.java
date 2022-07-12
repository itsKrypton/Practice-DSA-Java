import java.util.Comparator;
import java.util.PriorityQueue;

public class PoliceStation {

    public static void main(String args[])
    {
        System.out.println(solve(3, 10, new int[]{2, 4, 3}));
    }
    public static int solve(int N, int a, int[] x) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>();
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(Comparator.reverseOrder());
        int minV = Integer.MAX_VALUE, maxV = Integer.MIN_VALUE;
        for(int i=0; i<N; i++)
        {
            pqMax.add(x[i]);
            if(pqMax.size() > 2)
            pqMax.poll();

            pqMin.add(x[i]);
            if(pqMin.size() > 2)
            pqMin.poll();

            minV = Math.min(minV, x[i]);
            maxV = Math.max(maxV, x[i]);
        }
        int max = Math.max((Math.abs(pqMax.poll() - a) + Math.abs(pqMax.poll() - a)), (Math.abs(pqMin.poll() - a) + Math.abs(pqMin.poll() - a)));
        max = Math.max(max, (Math.abs(minV - a) + Math.abs(maxV - a)));
        return max;
    }
}
