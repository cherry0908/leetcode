import java.util.*;
import java.util.Arrays;

public class Main
{
    public void backtrack(int[] nums, int position, boolean[] visited, ArrayList<Integer> current, List<List<Integer>> result){
    	if(position == nums.length){
    		ArrayList<Integer> tmp = new ArrayList<Integer>(current);
    		result.add(tmp);
    		return;
    	}
    	for(int i=0;i<nums.length;i++){
    		if(visited[i] == false){
    		   if (i > 0 && nums[i] == nums[i-1] && visited[i-1] == false){
                        continue;
    		   }
    			current.add(nums[i]);
    			visited[i] = true;
    			backtrack(nums, position+1, visited, current, result);
    			current.remove(current.size()-1);
    			visited[i] = false;
    		}
    	}
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums == null || nums.length == 0){
    		return result;
    	}
    	ArrayList<Integer> current = new ArrayList<Integer>();
    	Arrays.sort(nums);
    	boolean[] visited = new boolean[nums.length];
    	for(int i=0;i<nums.length;i++){
    		visited[i] = false;
    	}
    	backtrack(nums, 0, visited, current, result);
    	return result;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {1,2,1};
        System.out.println("List: " + m.permuteUnique(nums));
	}
}
