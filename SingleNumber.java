//https://leetcode.com/problems/single-number/

public class SingleNumber {
    public static void main(String args[])
    {
        int[] arr = {4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] arr)
    {
        int ans = 0;
        for(int i : arr)
        ans ^= i;

        return ans;
    }

    /*
     * We are Xoring all the numbers and as bitwise operators are associative, all same numbers will result in 0 and at the end 0 XOR unique number will result
     * in unique number
     */
}
