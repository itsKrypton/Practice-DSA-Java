import java.util.*;

public class SelectionSortRecur {
    public static void main(String args[])
    {
        int arr[] = {4, 3, 2, 1};
        sort(arr, arr.length - 1, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[], int row, int column, int max)
    {
        if(row == 0)
        return;

        if(column <= row)
        {
            if(arr[column] > arr[max])
            max = column;
            
            sort(arr, row, ++column, max);
        }

        else
        {
            int temp = arr[row];
            arr[row] = arr[max];
            arr[max] = temp;

            sort(arr, --row, 0, 0);
        }
    }
}
