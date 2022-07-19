//https://leetcode.com/problems/flipping-an-image/submissions/

import java.util.Arrays;

public class FlippingAnImage {
    public static void main(String args[])
    {
        int arr[][] = {
            {1,1,0},
            {1,0,1},
            {0,0,0}
        };
        flipAndInvertImage(arr);

        for(int[] row : arr)
        System.out.println(Arrays.toString(row));
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        for(int[] row : image)
        reverseAndXOR(row);

        return image;
    }

    public static void reverseAndXOR(int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end)
        {
            int temp = (arr[start] ^ 1);
            arr[start] = (arr[end] ^ 1);
            arr[end] = temp;

            start++;
            end--;
        }
    } 
}
