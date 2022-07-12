import java.util.*;

public class ReverseArrayGroup {

    public static void main(String args[])
    {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        reverseInGroups(arr, arr.size(), 3);
    }

    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) 
    {
        int i = 0;
        k = k-1;
        while(i<=n)
        {
            for(i=i+k;i>=i;i--)
            {
                System.out.println(arr.get(i));
            }
            if((i+(k+1))<=n)
            i+=(k+1);
            else
            i+=((k+1)-i);
        }
    }
}
