import java.util.*;
import java.util.Arrays;

public class Main
{
	
	public void backtrack(int[] candidates, int k, int target, int start, List<Integer> current, List<List<Integer>> result) {
    	if (current.size() == k && target == 0) {
    		ArrayList<Integer> tmp = new ArrayList<Integer>(current);
    		result.add(tmp);
    		return;
    	}
    	for (int i = start; i < candidates.length; i++) {
    		if (target < candidates[i]) return;
            current.add(candidates[i]);
		    backtrack(candidates, k, target - candidates[i], i + 1, current, result);
		    current.remove(current.size() - 1);
    	}
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = {1,2,3,4,5,6,7,8,9};
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (candidates == null || candidates.length == 0) {
    		return result;
    	}
    	
    	ArrayList<Integer> current = new ArrayList<Integer>();
    	Arrays.sort(candidates);
    	backtrack(candidates, k, n, 0, current, result);
    	return result;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    
        System.out.println("List: " + m.combinationSum3(2,7));
	}
}
