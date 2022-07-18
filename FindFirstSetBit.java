//https://practice.geeksforgeeks.org/problems/find-first-set-bit-1587115620/1

public class FindFirstSetBit {
    public static void main(String args[])
    {
        System.out.println(getFirstSetBit(0));
    }

    public static int getFirstSetBit(int n)
    {
        if(n == 0)
        return 0;

        int counter = 0;
        while(true)
        {
            int ans = (n & (1 << counter)) >> counter;
            if(ans == 1)
            return counter + 1;

            counter++;
        }  
    }
}
