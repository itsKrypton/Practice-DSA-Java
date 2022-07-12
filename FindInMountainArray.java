//https://leetcode.com/problems/find-in-mountain-array/

public class FindInMountainArray {
    public static void main(String args[])
    {
        int[] mountainArr = {18,29,38,59,98,100,99,98,90};
        int target = 100;
        System.out.println(findInMountainArray(target, mountainArr));
    }

    public static int findInMountainArray(int target, int[] mountainArr) {
        int peak = peak(mountainArr);
        if(target > mountainArr[peak])
        return -1;

        int answer = binarySearch(mountainArr, 0, peak, target, true);

        if (answer != -1)
        return answer;

        return binarySearch(mountainArr, peak, mountainArr.length - 1, target, false);
    }

    public static int peak(int[] mountainArr)
    {
        int start = 0;
        int end = mountainArr.length - 1;

        while(start < end)
        {
            int mid = start + (end - start)/2;

            if (mountainArr[mid] < mountainArr[mid+1])
            start = mid + 1;

            else
            end = mid;
        }

        return start;
    }

    public static int binarySearch(int[] mountainArr, int start, int end, int target, boolean isAscending)
    {
        while(start <= end)
        {
            int mid = start + (end - start)/2;

            if(mountainArr[mid] == target)
            return mid;

            if(isAscending)
            {
                if(mountainArr[mid] < target)
                start = mid + 1;

                else if(mountainArr[mid] > target)
                end = mid - 1;
            }

            else
            {
                if(mountainArr[mid] < target)
                end = mid - 1;

                else if(mountainArr[mid] > target)
                start = mid + 1;
            }
        }
        return -1;
    }
}
