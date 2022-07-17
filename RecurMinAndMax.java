//https://www.geeksforgeeks.org/recursive-programs-to-find-minimum-and-maximum-elements-of-array/ 

public class RecurMinAndMax {
    public static void main(String args[])
    {
        int[] arr = {1, 4, 3, -5, -4, 8, 6};
        int[] ans = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        minMax(arr, 0, arr.length, ans);
        System.out.println("min = " + ans[0] + ", max = " + ans[1]);
    }

    public static int[] minMax(int[] arr, int index, int length, int[] ans)
    {
        if(index == length)
        return ans;

        ans[0] = Math.min(ans[0], arr[index]);
        ans[1] = Math.max(ans[1], arr[index]);

        return(minMax(arr, ++index, length, ans));
    }
}
