//https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/

public class KthBitInNthBinaryString {
    public static void main(String[] args) 
    {
        System.out.println(findKthBit(4, 11));
    }

    public static char findKthBit(int n, int k) {
        String x = helper(n, new StringBuilder("0"));
        return x.charAt(k - 1);
    }

    public static String helper(int n, StringBuilder x)
    {
        if(n == 1)
        return x.toString();

        String reverse = reverseInvert(x.toString());
        return helper(n - 1, x.append(1).append(reverse));
    }

    public static String reverseInvert(String x)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < x.length(); i++)
        {
            if(x.charAt(i) == '1')
            sb.append('0');

            else
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
