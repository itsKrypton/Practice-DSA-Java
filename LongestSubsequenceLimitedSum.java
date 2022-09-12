import java.util.Arrays;

public class LongestSubsequenceLimitedSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(answerQueries(new int[]{4,5,2,1}, new int[]{3,10,21})));
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        int[] answer = new int[queries.length];
        Arrays.sort(nums);

        for(int i=0; i<queries.length; i++)
        {
            int targetSum = queries[i];
            int currentSum = 0;
            int currentCount = 0;

            if(nums[0] > targetSum)
            {
                answer[i] = 0;
                continue;
            }


            for(int j=0; j<nums.length; j++)
            {
                if(currentSum + nums[j] <= targetSum)
                {
                    currentSum += nums[j];
                    currentCount++;

                    if(j == nums.length-1)
                    {
                        answer[i] = currentCount;
                        break;
                    }
                }

                else
                {
                    answer[i] = currentCount;
                    break;
                }
            }
        }

        return answer;
    }
}
