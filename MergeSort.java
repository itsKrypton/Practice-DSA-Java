// Merge Sort with extra space, we are making new arrays everytime we divide our array

import java.util.Arrays;

public class MergeSort {
    public static void main(String args[])
    {
        int arr[] = {5, 4, 3, 2, 1};
        arr = sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sort(int arr[])
    {
        if(arr.length == 1)
        return arr; // to return the individual elements

        int mid = arr.length / 2;

        int left[] = sort(Arrays.copyOfRange(arr, 0, mid)); // sort left side
        int right[] = sort(Arrays.copyOfRange(arr, mid, arr.length)); // sort right side

        return merge(left, right); // merge both
    }

    public static int[] merge(int[] left, int[] right)
    {
        int i = 0, j = 0, k = 0;

        int mix[] = new int[left.length + right.length];
        while(i < left.length && j < right.length)
        {
            if(left[i] < right[j])
            {
                mix[k] = left[i];
                i++;
                k++;
            }

            else
            {
                mix[k] = right[j];
                j++;
                k++;
            }
        }

        while(i < left.length)
        {
            mix[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length)
        {
            mix[k] = right[j];
            j++;
            k++;
        }

        return mix;
    }
}
