import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {100, 200, 4, 12};
        List<List<Integer>> answers = combinationSum(candidates, 400);

        for(List<Integer> answer : answers)
        System.out.print(answer);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinations(candidates, target, new ArrayList<>(), 0);
    }

    public static List<List<Integer>> combinations(int[] candidates, int target, List<Integer> answer, int index)
    {
        List<List<Integer>> answers = new ArrayList<>();
        //found answer
        if(target == 0)
        {
            answers.add(new ArrayList<>(answer));
            return answers;
        }
        
        if(target < 0)
        return answers;

        for(int i = index; i < candidates.length; i++)
        {
            answer.add(candidates[i]);
            answers.addAll(combinations(candidates, target - candidates[i], answer, i));
            answer.remove(answer.size() - 1);
        }

        return answers;
    }

    // With answers in the argument list
    /* public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinations(candidates, target, new ArrayList<>(), new ArrayList<>(), 0);
    }

    public static List<List<Integer>> combinations(int[] candidates, int target, List<Integer> answer, List<List<Integer>> answers, int index)
    {
        //found answer
        if(target == 0)
        answers.add(new ArrayList<>(answer));
        
        if(target < 0)
        return answers;

        for(int i = index; i < candidates.length; i++)
        {
            answer.add(candidates[i]);
            combinations(candidates, target - candidates[i], answer, answers, i);
            answer.remove(answer.size() - 1);
        }
        
        return answers;
    } */
}
