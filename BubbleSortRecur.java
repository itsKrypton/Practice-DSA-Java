import java.util.Arrays;

public class BubbleSortRecur {
    public static void main(String args[])
    {
        int arr[] = {5, 6, 4, 8, 3, 4, 1, 9, 7, 3};
        sort(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[], int row, int column)
    {
        if(row == 0)
        return;

        if(column < row)
        {
            if(arr[column] > arr[column + 1])
            {
                int temp = arr[column];
                arr[column] = arr[column + 1];
                arr[column + 1] = temp;
            }
            sort(arr, row, ++column);
        }

        else
        sort(arr, --row, 0);
    }
}
