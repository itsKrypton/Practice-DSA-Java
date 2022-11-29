public class PivotInteger {
    public int pivotInteger(int n) {
        for(int i = 1; i <= 8; i++)
        {
            int leftSum = (i * (i+1)) / 2;
            int rightSum = (n * (n+1)) / 2;

            if(leftSum == rightSum)
            return i;
        }

        return -1;
    }
}
