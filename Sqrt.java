//https://leetcode.com/problems/sqrtx/

public class Sqrt {
    /* public static void main(String args[])
    {
        System.out.printf("%.3f", mySqrt(8));
    } */
    
    public static int mySqrt(int x) 
    {
        long start = 0;
        long end = x;
        
        while(start <= end)
        {
            long mid = start + (end - start) / 2;
            
            if(mid * mid == x)
                return (int)mid;
            
            else if(mid * mid > x)
                end = mid - 1;
            
            else
                start = mid + 1;
        }
        
        return (int)end;

        //if precision is needed then,

        /* double root = 0.0;

        int start = 0;
        int end = x;
        
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            
            if(mid * mid == x)
                return mid;
            
            else if(mid * mid > x)
                end = mid - 1;
            
            else
                start = mid + 1;
        }
        
        root = end;

        double precision = 0.1;
        int p = 3;

        for(int i=0; i<p; i++)
        {
            while (root * root <= x)
            root += precision;

            root -= precision;
            precision /= 10;
        }

        return root; */
    }
}
