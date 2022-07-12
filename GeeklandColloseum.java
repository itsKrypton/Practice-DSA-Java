// https://practice.geeksforgeeks.org/contest/job-a-thon-exclusive-hiring-challenge-for-amazon-alexa/problems/#
/*
 * In this problem, you need to find two arrays, prefMax and sufMin such that it finds the maximum and minimum of N values at every index.
 * Then you just compare ith and ith+1 indexes of the two arrays to find the maximum difference of them.
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class GeeklandColloseum {
    public static void main(String args[])
    {
        System.out.println(colosseum(2, new int[]{1, 3, 5, 2, 1, 1}));
    }

    public static long colosseum(int N,int A[]) {
        PriorityQueue<Integer> prefMax = new PriorityQueue<>();
        PriorityQueue<Integer> sufMin = new PriorityQueue<>(Comparator.reverseOrder());
        long sumToLeft[] = new long[3*N];
        long sumToRight[] = new long[3*N];

        long sum = 0;
        for(int i=0; i<3*N; i++)
        {
            prefMax.add(A[i]);
            sum += A[i];
            if(prefMax.size() > N)
            {
                sum -= prefMax.peek();
                prefMax.poll();
            }
            sumToRight[i] = sum;
        }

        sum = 0;
        for(int i=(3*N)-1; i>=0; i--)
        {
            sufMin.add(A[i]);
            sum += A[i];
            if(sufMin.size() > N)
            {
                sum -= sufMin.peek();
                sufMin.poll();
            }
            sumToLeft[i] = sum;
        }

        long max = Long.MIN_VALUE;
        for(int i=(N-1); i<(2*N); i++)
        max = Math.max(max, sumToRight[i] - sumToLeft[i+1]);

        return max;
    }






























    /* public static long colosseum(int N,int A[]) {
        bubbleSortReverse(A, 0, (int)(N*1.5));
        bubbleSortReverse(A, (int)(N*1.5), (3*N));
        
        long answer = 0;
        for(int i=0; i<N; i++)
        answer+= A[i];

        for(int i=(2*N); i<(3*N); i++)
        answer-= A[i];

        return answer;
    }

    public static void bubbleSortReverse(int arr[], int start, int end)
    {
        int count = 0;
        for (int i = start; i < end - 1; i++)
        {
            for (int j = start; j < end - count - 1; j++)
            {
                if (arr[j] < arr[j + 1]) 
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            count++;
        }
    } */
    /* public static long colosseum(int N,int A[]) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>();
        PriorityQueue<Integer> pqMin = new PriorityQueue<>(Comparator.reverseOrder());

        for(long i=0; i<N*1.5; i++)
        {
            pqMax.add(A[(int)i]);
            if(pqMax.size() > N)
            pqMax.poll();
        }

        for(long i=(long)(N*1.5); i<N*3; i++)
        {
            pqMin.add(A[(int)i]);
            if(pqMin.size() > N)
            pqMin.poll();
        }

        long answer = 0;
        while(!pqMax.isEmpty() && !pqMin.isEmpty())
        {
            answer += pqMax.poll();
            answer -= pqMin.poll();
        }

        return answer;
    } */
}
