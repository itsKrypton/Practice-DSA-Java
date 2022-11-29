// https://leetcode.com/contest/biweekly-contest-92/problems/minimum-cuts-to-divide-a-circle/

public class MinimumCutsDivideCircle {
    public int numberOfCuts(int n) {
        if(n == 1)
        return 0;

        else if(n%2 == 0)
        return n/2;

        else
        return n;
    }
}
