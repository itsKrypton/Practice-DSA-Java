import java.util.Arrays;

/*
 * Choose the first element as pivot, keep all smaller elements from it to the left and bigger elements to the right of it.
 */

public class QuickSort {
    public static void main(String args[])
    {
        int arr[] = {3, 2, 1, 5, 6, 4};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[], int low, int high)
    {
        if(low >= high)
        return;

        int start = low;
        int end = high;
        int pivot = arr[start];

        while(start < end)
        {
            while(arr[start] <= pivot && start <= high - 1)
            start++;

            while(arr[end] > pivot && end >= low + 1)
            end--;

            if(start < end)
            {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }

        // Placing the pivot to it's correct position
        int temp = arr[low];
        arr[low] = arr[end];
        arr[end] = temp;

        // Sort left side
        sort(arr, low, end - 1);

        // Sort right side
        sort(arr, end + 1, high);
    }
}
