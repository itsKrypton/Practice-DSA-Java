//import java.util.HashSet;

// This approach uses fast and slow pointer cycle detection, constant space and faster.
public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do
        {
            slow = findSquare(n);
            fast = findSquare(findSquare(n));
        } 
        while(slow != fast);

        if(slow == 1)
        return true;

        return false;
    }

    public static int findSquare(int n)
    {
        int sum = 0;
        while(n > 0)
        {
            int lastDigit = n % 10;
            sum += lastDigit * lastDigit;
            n /= 10;
        }
        return sum;
    }

    /* public boolean isHappy(int n) {
        HashSet<Integer> mySet = new HashSet<>();

        if(n == 1)
        return true;

        mySet.add(n);
        while(n != 1)
        {
            int sum = 0;
            while(n > 0)
            {
                int lastDigit = n % 10;
                sum += lastDigit * lastDigit;
                n /= 10;
            }

            if(sum == 1)
            return true;

            if(mySet.contains(sum))
            return false;

            mySet.add(sum);
            n = sum;
        }

        return false;
    } */
}
