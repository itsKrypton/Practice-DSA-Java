// https://www.codingninjas.com/codestudio/problems/longest-bitonic-sequence_1062688?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1

import java.util.Arrays;

// Similar to LIS problem and uses concept similar to prefix and suffix array. Here we are creating LIS dp tables from left to right and right to left till a specific
// index. After that we add the dp1 and dp2 values for a specific index and the answer is the maximum value for all the indexes.

public class LongestBitonicSubsequence {
    public static int longestBitonicSequence(int[] arr, int n) {
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for(int i = 0; i < n; i++)
        {
            for(int prev = 0; prev < i; prev++)
            {
                if(arr[prev] < arr[i])
                dp1[i] = Math.max(dp1[i], 1 + dp1[prev]);
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--)
        {
            for(int prev = n - 1; prev > i; prev--)
            {
                if(arr[prev] < arr[i])
                dp2[i] = Math.max(dp2[i], 1 + dp2[prev]);
            }

            max = Math.max(max, dp1[i] + dp2[i] - 1);
        }

        return max;
    }
}
