public class SortedOrNotRecur {
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3, 5, 4};
        System.out.println(check(arr, 0));
    }

    public static boolean check(int[] arr, int index)
    {
        if(index == arr.length - 1)
        return true;

        /* if(arr[index] > arr[index + 1])
        return false;

        else
        return check(arr, ++index); */

        //other way of doing it

        return arr[index] <= arr[index + 1] && check(arr, ++index);
    }
}
