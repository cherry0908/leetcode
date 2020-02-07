import java.util.*;
import java.util.Arrays;

public class Main
{
    public void backtrack(int[] nums, int start, ArrayList<Integer> current, List<List<Integer>> result){
        ArrayList<Integer> tmp = new ArrayList<Integer>(current);
        result.add(tmp);
        for(int i=start;i<nums.length;i++){
            if(i==start || nums[i] != nums[i-1]){
                current.add(nums[i]);
                backtrack(nums, i+1, current, result);
                current.remove(current.size()-1);
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        backtrack(nums, 0, current, result);
        return result;
    }
	
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {2,2,1};
        System.out.println("List: " + m.subsetsWithDup(nums));
	}
}
