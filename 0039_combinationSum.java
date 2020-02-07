import java.util.*;
import java.util.Arrays;

public class Main
{
	public void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result){
	    if(target == 0){
	        ArrayList<Integer> temp = new ArrayList<Integer>(current);
	        result.add(temp);
	        return;
	    }
	    for(int i = start; i < candidates.length; i++){
	        if(candidates[i] > target) break;
	        current.add(candidates[i]);
	        backtrack(candidates, target - candidates[i], i, current, result);
	        current.remove(current.size()-1);
	    }
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    if(candidates == null || candidates.length == 0){
	        return result;
	    }

	    Arrays.sort(candidates);
        ArrayList<Integer> current = new ArrayList<Integer>();

        backtrack(candidates, target, 0, current, result);
        return result;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {2,3,5};
        System.out.println("List: " + m.combinationSum(nums, 8));
	}
}