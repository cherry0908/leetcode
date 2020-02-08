import java.util.*;
import java.util.Arrays;

public class Main
{
	
	public void backtrack(int n, int target, int start, ArrayList<Integer> current, List<List<Integer>> result) {
    	if (target == 0) {
    		ArrayList<Integer> tmp = new ArrayList<Integer>(current);
    		result.add(tmp);
    		return;
    	}
    	for (int i = start; i < n; i++) {
    		current.add(i);
    		backtrack(n, target-1, i + 1, current, result);
    		current.remove(current.size() - 1);
    	}
    }
    
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (n == 0) {
    		return result;
    	}
    	
    	ArrayList<Integer> current = new ArrayList<Integer>();
    	backtrack(n+1, k, 1, current, result);
    	return result;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
        System.out.println("List: " + m.combine(4, 2));
	}
}
