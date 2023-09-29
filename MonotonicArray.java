public class MonotonicArray {
    /* public boolean isMonotonic(int[] nums) {
        // Skip the same numbers
        int index = 0;
        while(index < nums.length - 1 && nums[index] == nums[index + 1])
            index++;

        // Return true if we reached the end
        if(index == nums.length - 1) return true;

        // Set increasing or decreasing
        boolean isIncreasing = (nums[index] < nums[index + 1]);
        // Traverse the entire array and check if the pattern is maintained or not.
        while(index < nums.length - 1)
        {
            if((isIncreasing && nums[index] > nums[index + 1]) || (!isIncreasing && nums[index] < nums[index + 1]))
                return false;

            index++;
        }

        return true;
    } */

    // A bit less complex than above
    public boolean isMonotonic(int[] nums) {
        // isIncreasing = 1 (ascending), 0 (descending), -1 (not set)
        int isIncreasing = -1;
        for(int i = 0; i < nums.length - 1; i++)
        {
            // If numbers are in ascending order
            if(nums[i] < nums[i + 1])
            {
                // If isIncreasing is not set already then set it
                if(isIncreasing == -1)
                    isIncreasing = 1;

                // If it's already set to descending then return false
                else if(isIncreasing == 0)
                    return false;
            }

            // If numbers are in descending order
            else if(nums[i] > nums[i + 1])
            {
                // If isIncreasing is not set already then set it
                if(isIncreasing == -1)
                    isIncreasing = 0;

                // If it's already set to ascending then return false
                else if(isIncreasing == 1)
                    return false;
            }
        }

        return true;
    }
}
