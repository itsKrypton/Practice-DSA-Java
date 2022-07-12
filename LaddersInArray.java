import java.util.*;
public class LaddersInArray {

    static ArrayList<Integer> leaders(int arr[], int n)
    {
        ArrayList<Integer> output = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i=(n-1); i>0; i--)
        {
            if(arr[i]>max)
            {
                max = arr[i];
                output.add(arr[i]);
            }
        }   
        Collections.reverse(output);
        return output;
    }
}
