//https://www.geeksforgeeks.org/find-value-k-th-bit-binary-representation/

public class KthBitWithBitwise {
    public static void main(String args[])
    {
        int a = 10;
        System.out.println(kthBit(a, 2));
    }

    public static int kthBit(int number, int bitPos)
    {
        return (number & (1 << (bitPos - 1))) >> (bitPos - 1);
        /*
         * Here we are getting 10 by doing (1 << (bitPos - 1)) and that we are anding with the number to get the bit at the specified postion.
         * The answer is then right shifted (bitPos - 1) to get the bit.
         */
    }
}
