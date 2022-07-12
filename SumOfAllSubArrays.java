import java.util.ArrayList;

public class SumOfAllSubArrays {
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(max_of_subarrays(arr, arr.length, 3));
    }
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> max = new ArrayList<>();
        if(k == 1)
        {
            for(int i : arr)
            max.add(i);
            return max;
        }

        int valueAtStartOfSubArray = arr[0];
        int sum = 0;

        for(int i=0; i<k; i++)
        sum += arr[i];
        max.add(sum);

        for(int i=k; i<n; i++)
        {
            sum = sum - valueAtStartOfSubArray + arr[i];
            max.add(sum);
            valueAtStartOfSubArray = arr[i-(k-1)];
        }
        return max;
    }
}
