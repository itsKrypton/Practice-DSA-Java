// https://leetcode.com/problems/integer-break/?envType=daily-question&envId=2023-10-06

public class IntegerBreak {
    public int integerBreak(int n) {
        // If the number is less than or equal to three then the answer would be number - 1
        if(n < 4) return n - 1;

        // Else, find the number of times we can divide the number by 3 and also store the remainder
        int numberOfThrees = n / 3, remainder = n % 3;

        /*
         * If the remainder is 0 then divide n into all threes. Else if 1 remains then convert the last 3 to 4 as multiplying 4 is better
         * than multiplying 3 * 1. Else, if two remains then multiply that to the answer after making rest of it to threes.
         */
         
        return (remainder == 0) ? (int)Math.pow(3, numberOfThrees) : 
            (remainder == 1) ? (int)Math.pow(3, numberOfThrees - 1) * 4 : (int)Math.pow(3, numberOfThrees) * 2;
    }
}
