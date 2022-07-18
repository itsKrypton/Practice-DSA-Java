public class OddOrEvenWithBitwise
{
    public static void main(String args[])
    {
        System.out.println(isOdd(4));
    }

    public static boolean isOdd(int number)
    {
        return (number & 1) == 1;
        /*
         * Binary of 3 that is 11 now & that with 1 would give 1 as any number and with 1 gives the same number itself,
         * if the answer equals to 1 then the number is odd as all the bits before lsb already are even so adding 1 to that would result in odd number.
         */
    }
}