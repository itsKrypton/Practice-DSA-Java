public class BinarySearchSorted2DArray {
    public static void main(String args[])
    {
        int arr[][] = {
            {1, 5, 10},
            {15, 20, 25}
        };
        int target = 12;

        int sRow = 0;
        int eRow = arr.length - 1;
        boolean valueFound = false;

        while(sRow <= eRow)
        {
            int mid = sRow + (eRow - sRow) / 2;
            if(arr[mid][0] <= target && arr[mid][arr[mid].length - 1] >= target)
            {
                int colValue = binarySearch(arr[mid], 0, arr[mid].length-1, target);
                if(colValue == -1)
                System.out.println("-1, -1");

                else
                {
                    System.out.println(mid + ", " + colValue);
                    valueFound = true;
                }

                break;
            }

            else if(arr[mid][arr[mid].length - 1] < target)
            sRow = mid + 1;

            else 
            eRow = mid - 1;
        }

        if(!valueFound)
        System.out.println("-1, -1");
    }

    public static int binarySearch(int[] row, int start, int end, int target)
    {
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(row[mid] == target)
            return mid;

            else if(row[mid] > target)
            end = mid - 1;

            else
            start = mid + 1;
        }

        return -1;
    }
}
