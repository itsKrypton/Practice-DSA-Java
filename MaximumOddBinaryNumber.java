/*
 * Find the number of ones, bring all those ones - 1 to the beginning of the string and add the remaining single one at the end to get the largest odd binary number.
 */

public class MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        int numberOfOnes = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '1')
                numberOfOnes++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < numberOfOnes - 1; i++)
            sb.append('1');
        
        for(int i = 0; i < s.length() - numberOfOnes; i++)
            sb.append('0');
        
        sb.append('1');
        
        return sb.toString();
    }
}
