//https://leetcode.com/problems/knight-probability-in-chessboard/

import java.util.Arrays;

//Problem incomplete, need to implement proper DP

public class KnightProbabilityInChess {
    public static void main(String[] args) {
        System.out.println(knightProbability(5, 2, 3, 3));
    }

    public static double knightProbability(int n, int k, int row, int column)
    {
        double dp[][] = new double[n][n];

        for(double rows[] : dp)
        Arrays.fill(rows, -1);

        return helper(n, k, row, column, dp);
    }

    public static double helper(int n, int k, int row, int column, double dp[][]) 
    {
        if(k == 0)
        return 1.0;

        if(dp[row][column] != -1)
        return dp[row][column];

        double ways = 0.0;

        if(isValid(n, row - 1, column - 2))
        ways += helper(n, k - 1, row - 1, column - 2, dp);

        if(isValid(n, row + 1, column - 2))
        ways += helper(n, k - 1, row + 1, column - 2, dp);

        if(isValid(n, row - 2, column - 1))
        ways += helper(n, k - 1, row - 2, column - 1, dp);

        if(isValid(n, row - 2, column + 1))
        ways += helper(n, k - 1, row - 2, column + 1, dp);

        if(isValid(n, row - 1, column + 2))
        ways += helper(n, k - 1, row - 1, column + 2, dp);

        if(isValid(n, row + 1, column + 2))
        ways += helper(n, k - 1, row + 1, column + 2, dp);

        if(isValid(n, row + 2, column - 1))
        ways += helper(n, k - 1, row + 2, column - 1, dp);

        if(isValid(n, row + 2, column + 1))
        ways += helper(n, k - 1, row + 2, column + 1, dp);

        dp[row][column] = ways/8;
        return ways/8;
    }

    public static boolean isValid(int n, int row, int col)
    {
        if(row >= 0 && row < n && col >=0 && col < n)
        return true;

        return false;
    }

    //Without DP only recursion, gives TLE
    /*
    public double knightProbability(int n, int k, int row, int column) 
    {
        if(k == 0)
        return 1;

        double ways = 0;

        if(isValid(n, row - 1, column - 2))
        ways += knightProbability(n, k - 1, row - 1, column - 2);

        if(isValid(n, row + 1, column - 2))
        ways += knightProbability(n, k - 1, row + 1, column - 2);

        if(isValid(n, row - 2, column - 1))
        ways += knightProbability(n, k - 1, row - 2, column - 1);

        if(isValid(n, row - 2, column + 1))
        ways += knightProbability(n, k - 1, row - 2, column + 1);

        if(isValid(n, row - 1, column + 2))
        ways += knightProbability(n, k - 1, row - 1, column + 2);

        if(isValid(n, row + 1, column + 2))
        ways += knightProbability(n, k - 1, row + 1, column + 2);

        if(isValid(n, row + 2, column - 1))
        ways += knightProbability(n, k - 1, row + 2, column - 1);

        if(isValid(n, row + 2, column + 1))
        ways += knightProbability(n, k - 1, row + 2, column + 1);

        return ways/8;
    }

    public static boolean isValid(int n, int row, int col)
    {
        if(row >= 0 && row < n && col >=0 && col < n)
        return true;

        return false;
    }
    */
}
