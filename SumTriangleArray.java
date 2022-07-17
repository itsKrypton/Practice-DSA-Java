//https://www.geeksforgeeks.org/sum-triangle-from-array/ with Recursion

import java.util.Arrays;

public class SumTriangleArray {
    public static void main(String args[])
    {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        if(arr.length > 1)
        sumTriangle(arr);   

        System.out.println(Arrays.toString(arr));
    }

    public static void sumTriangle(int arr[])
    {   
        int[] temp = new int[arr.length - 1];
        for(int i = 0; i < arr.length - 1; i++)
        temp[i] = arr[i] + arr[i+1];

        if(temp.length == 1)
        {
            System.out.println(Arrays.toString(temp));
            return;
        }

        sumTriangle(temp);
        System.out.println(Arrays.toString(temp));
    }
}
