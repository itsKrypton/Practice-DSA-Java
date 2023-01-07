public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        long sum = sum(nums);

        if(sum%p == 0) return 0;
        int ans = find(0, nums, p, sum, 0);

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public static int find(int index, int[] nums, int p, long sum, int count)
    {
        if(sum%p == 0) return count;
        if(index >= nums.length) return Integer.MAX_VALUE;

        int currentCount = Integer.MAX_VALUE;
        for(int i = index; i < nums.length && (sum - nums[i]) >= p; i++)
        currentCount = Math.min(currentCount, find(index + 1, nums, p, sum - nums[i], count + 1));

        return currentCount;
    }

    public static long sum(int[] nums)
    {
        long sum = 0;

        for(int i : nums)
        sum += i;

        return sum;
    }
}
