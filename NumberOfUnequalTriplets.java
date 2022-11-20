public class NumberOfUnequalTriplets {
    public int unequalTriplets(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length; i++)
        {
            for(int j = 1; j < nums.length; j++)
            {
                for(int k = 2; k < nums.length; k++)
                {
                    if(i == j || j == k || i == k)
                    continue;

                    if(nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k])
                    count++;
                }
            }

        }

        return count;
    }
}
