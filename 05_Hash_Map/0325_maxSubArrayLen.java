import java.util.*;
public class Main
{
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        if(nums == null || len == 0) return 0;
        int sum = 0, result = Integer.MIN_VALUE, diff = 0;
        // hashmap, key is the prefix sum, value is the smallest index
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // hashmap init (0, -1) for the subarray starting from index=0
        map.put(0, -1);
        for(int i = 0; i < len; i ++){
            sum = sum + nums[i];
            diff = sum - k;
            if(map.containsKey(diff)){
                result = Math.max(result, i - map.get(diff));
            }
            // if the prefix sum exist in the map, no need to update because the previous index is smaller
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        if(result == Integer.MIN_VALUE){
            return 0;
        }
        else{
            return result;
        }
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {1,-1,5,-2,3};
        System.out.println("result: " + m.maxSubArrayLen(nums, 3));
	}
}