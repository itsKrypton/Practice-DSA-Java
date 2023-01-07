//https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/

import java.util.Arrays;

public class MaximumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {        
        Arrays.sort(tasks);

        int count = 0;
        int rounds = 0;

        for(int i = 0; i < tasks.length; i++)
        {
            count++;

            if(i == tasks.length - 1 || tasks[i] != tasks[i+1])
            {
                if(count == 1) return -1;

                rounds += (count/3);

                if(count%3 != 0)
                rounds += 1;

                count = 0;
            }
        }

        return rounds;
    }
}
