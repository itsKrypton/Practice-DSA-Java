public class CountingBits {
    /*
     * Instead of checking all the bits, we can use a property of binary numbers, i.e, a number will have the same number of bits as that of number / 2 + 1(if current
     * number is odd). Try taking some examples and see. 
     * T: O(n)
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for(int i = 0; i <= n; i++)
        ans[i] = ans[i >> 1] + (i & 1);

        return ans;
    }

    // Check all the bits of a particular number
    // T: O(32n)
    /* public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for(int i = 0; i <= n; i++)
        {
            int bitCount = 0;
            for(int j = 0; j < 32; j++)
            {
                if(((i >> j) & 1) == 1)
                bitCount++;
            }

            ans[i] = bitCount;
        }

        return ans;
    } */
}
