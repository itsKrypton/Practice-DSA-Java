// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

/*
 * We first sort the array on the basis of their second value. Then just check if the current balloon start is greater than the previous balloons end. If it is then
 * increase the number of rounds because we will need another arrow to shoot it and also set the previous balloon to current balloon.
 */

import java.util.Arrays;

public class MinimumNumberOfArraysToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0])); //lambda function no need to implement comparator interface
        int previous = 0;
        int rounds = 1;

        for(int i = 1; i < points.length; i++)
        {
            if(points[i][0] > points[previous][1])
            {
                rounds++;
                previous = i;
            }
        }
        
        return rounds;
    }
}
