public class NoOfStepsToReduceToZero {
    public static void main(String args[])
    {
        System.out.println(numberOfSteps(14));
    }
    public static int numberOfSteps(int num) {
        return count(num, 0);
    }

    public static int count(int num, int count)
    {
        if(num == 0)
        return count;

        if((num&1) == 0) // Equal to num%2 == 0
        return count(num >> 1 /* Equal to num / 10 */, ++count);

        else
        return count(num - 1, ++count);
    }
}
