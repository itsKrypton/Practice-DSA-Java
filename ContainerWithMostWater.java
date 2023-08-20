// https://leetcode.com/problems/container-with-most-water/description/

/*
 * Have two pointers and find the area with as x * y -> (high - low) * Math.min(height[low], height[high]). Everytime, increment/decrement the pointer having the lower
 * height to find a potentially larger area.
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int mostWater = 0, low = 0, high = height.length - 1;

        while(low < high)
        {
            mostWater = Math.max(mostWater, (high - low) * Math.min(height[low], height[high]));

            if(height[low] <= height[high])
            low++;

            else
            high--;
        }

        return mostWater;
    }
}
