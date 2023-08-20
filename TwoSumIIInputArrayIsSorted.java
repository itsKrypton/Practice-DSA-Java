// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;

        while(low < high)
        {
            if(numbers[low] + numbers[high] > target)
            high--;

            else if(numbers[low] + numbers[high] < target)
            low++;

            else
            return new int[]{low + 1, high + 1};
        }

        return new int[]{-1, -1};
    }
}
