import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String args[])
    {
        int arr[] = {5, 4, 3, 2, 1};
        sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[], int start, int end)
    {
        if(end - start == 1)
        return;

        int mid = (start + end) / 2;

        sort(arr, start, mid); // sort left side
        sort(arr, mid, end); // sort right side

        merge(arr, start, end, mid); // merge both
    }

    public static void merge(int[] arr, int start, int end, int mid)
    {
        int i = start, j = mid, k = 0;

        int mix[] = new int[end - start];
        while(i < mid && j < end)
        {
            if(arr[i] < arr[j])
            {
                mix[k] = arr[i];
                i++;
                k++;
            }

            else
            {
                mix[k] = arr[j];
                j++;
                k++;
            }
        }

        while(i < mid)
        {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while(j < end)
        {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for(i=0; i < mix.length; i++)
        arr[start + i] = mix[i];
    }
}
