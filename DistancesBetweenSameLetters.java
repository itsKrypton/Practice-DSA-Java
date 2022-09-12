////https://leetcode.com/contest/weekly-contest-309/problems/check-distances-between-same-letters/

import java.util.Arrays;

public class DistancesBetweenSameLetters {
    public boolean checkDistances(String s, int[] distance) {
        int[] array = new int[26];
        Arrays.fill(array, -1);

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if(array[ch - 'a'] == -1)
            array[ch - 'a'] = i;

            else
            array[ch - 'a'] = i - array[ch - 'a'];
        }

        for(int i = 0; i < array.length; i++)
        {
            if(array[i] >= 0)
            {
                if((array[i] - 1) == distance[i])
                continue;

                else
                return false;
            }
        }

        return true;
    }
}
