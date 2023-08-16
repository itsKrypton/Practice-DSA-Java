// https://leetcode.com/problems/product-of-array-except-self/description/

public class ProductOfArrayExceptSelf {
    // T: O(2n)
    // S: O(n) for answer array
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        // Store suffix product in answer array
        for(int i = nums.length - 1; i >= 0; i--)
        ans[i] = (i == nums.length - 1) ? nums[i] : ans[i + 1] * nums[i];

        // Just keep a track of prefProduct and we already have sufProduct in ans array.
        int prefProduct = 1;
        for(int i = 0; i < nums.length; i++)
        {
            ans[i] = (i == nums.length - 1) ? prefProduct : prefProduct * ans[i + 1];
            prefProduct *= nums[i];
        }

        return ans;
    }

    // T: O(2n)
    // S: O(2n) + O(n) for answer output

    /* public int[] productExceptSelf(int[] nums) {
        int[] prefProduct = new int[nums.length];
        int[] sufProduct = new int[nums.length];

        for(int i = 0; i < nums.length; i++)
        {
            if(i == 0)
            {
                prefProduct[i] = nums[i];
                sufProduct[nums.length - i - 1] = nums[nums.length - i - 1];
            }

            else
            {
                prefProduct[i] = prefProduct[i - 1] * nums[i];
                sufProduct[nums.length - i - 1] = sufProduct[nums.length - i] * nums[nums.length - i - 1];
            }
        }

        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            if(i == 0)
            ans[i] = sufProduct[i + 1];

            else if(i == nums.length - 1)
            ans[i] = prefProduct[i - 1];

            else
            ans[i] = prefProduct[i - 1] * sufProduct[i + 1];
        }

        return ans;
    } */
}
