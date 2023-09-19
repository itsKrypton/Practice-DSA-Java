import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {
    // T: n^2 + nlogk
    /* public int[] kWeakestRows(int[][] mat, int k) {
        // If the soldiers are same in two rows, store the later row before the current row as we are storing the ans in reverse
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] == b[1])
                return Integer.compare(b[0], a[0]);

            return Integer.compare(b[1], a[1]);
        });

        for(int i = 0; i < mat.length; i++)
        {
            int numberOfOnes = 0;
            for(int j : mat[i])
                if(j == 1)
                    numberOfOnes++;

            pq.add(new int[]{i, numberOfOnes});

            // If pq size goes over k, remove the strongest guy
            if(pq.size() > k)
                pq.remove();
        }

        int[] ans = new int[k];
        int i = k - 1;
        while(!pq.isEmpty())
            ans[i--] = pq.remove()[0];

        return ans;
    } */

    // We can make the searching of ones a bit more efficient by using binary search
    // T: nlogn + nlogk
    public int[] kWeakestRows(int[][] mat, int k) {
        // If the soldiers are same in two rows, store the later row before the current row as we are storing the ans in reverse
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] == b[1])
                return Integer.compare(b[0], a[0]);

            return Integer.compare(b[1], a[1]);
        });

        for(int i = 0; i < mat.length; i++)
        {
            int numberOfOnes = findNumberOfOnes(mat[i]);
            pq.add(new int[]{i, numberOfOnes});

            // If pq size goes over k, remove the strongest guy
            if(pq.size() > k)
                pq.remove();
        }

        int[] ans = new int[k];
        int i = k - 1;
        while(!pq.isEmpty())
            ans[i--] = pq.remove()[0];

        return ans;
    }

    public int findNumberOfOnes(int[] row)
    {
        int low = 0, high = row.length - 1;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(row[mid] == 0)
            high = mid - 1;

            else
            low = mid + 1;
        }

        return high + 1;
    }
}
