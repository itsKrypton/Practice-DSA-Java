// https://practice.geeksforgeeks.org/problems/n-digit-numbers-with-digits-in-increasing-order5903/1

import java.util.ArrayList;

public class NDigitNumbersIncreasing
{
    public static void main(String[] args) {
        System.out.println(increasingNumbers(8));
    }

    public static ArrayList<Integer> increasingNumbers(int N)
    {
        return helper(N, 0, 1);
    }

    public static ArrayList<Integer> helper(int N, int currentNumber, int startingNum)
    {
        ArrayList<Integer> answers = new ArrayList<>();

        if(currentNumber == 0 && N == 1)
        answers.add(currentNumber);

        else if(((int)Math.log10(currentNumber) + 1) == N)
        {
            answers.add(currentNumber);
            return answers;
        }

        for(int i = startingNum; i < 10; i++)
        answers.addAll(helper(N, (currentNumber * 10) + i, i + 1));

        return answers;
    }
}