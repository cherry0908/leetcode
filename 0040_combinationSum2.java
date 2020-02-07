import java.util.*;
import java.util.Arrays;

public class Main
{
	
	public void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
    	if (target == 0) {
    		ArrayList<Integer> tmp = new ArrayList<Integer>(current);
    		result.add(tmp);
    		return;
    	}
    	for (int i = start; i < candidates.length; i++) {
    		if (target < candidates[i]) return;
    		if (i == start || candidates[i] != candidates[i-1]){
                current.add(candidates[i]);
    		    backtrack(candidates, target - candidates[i], i + 1, current, result);
    		    current.remove(current.size() - 1);
            }
    	}
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (candidates == null || candidates.length == 0) {
    		return result;
    	}
    	
    	ArrayList<Integer> current = new ArrayList<Integer>();
    	Arrays.sort(candidates);
    	backtrack(candidates, target, 0, current, result);
    	return result;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {10,1,2,7,6,1,5};
        System.out.println("List: " + m.combinationSum2(nums, 8));
	}
}
