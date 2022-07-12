public class BinarySearch {

    public static void main(String args[])
    {
        int arr[] = new int[]{1,2,3,4,5};
        System.out.println(binarysearch(arr, arr.length, 6));
    }

    static int binarysearch(int arr[], int n, int k) 
    {
        int lb=0;
        int ub=n-1;
        while(lb<=ub)
        {
            int middle = (lb+ub)/2;
            if(k>arr[middle])
            {
                lb=middle+1;
            }

            else if(k<arr[middle])
            {
                ub=middle-1;
            }

            else if(k==arr[middle])
            return middle;
        }
        return -1;
    }
}
