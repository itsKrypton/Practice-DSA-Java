public class GCD {
    public int findGCD(int x, int y)  
    {  
        int r=0, a, b;  
        a = (x > y) ? x : y; 
        b = (x < y) ? x : y; 
        r = b;  
        while(a % b != 0)  
        {   r = a % b;  
            a = b;  
            b = r;  
        }  
        return r;  
    }  
}
