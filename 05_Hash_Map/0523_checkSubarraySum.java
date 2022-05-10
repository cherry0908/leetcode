import java.util.*;
public class Main
{
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if(nums == null || len < 2 || k == 0) return false;
        // hashmap to store the mod of a prefix sum
        // key is the mod of a prefix sum, value is the index of the nums which add up to prefix sum
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        // calculate prefix sum
        for(int i = 0; i < len; i++){
            sum = sum + nums[i];
            // i need to be at least 1
            if((sum == k || sum % k == 0) && i > 0) return true;
            // if the mod of sum divided by k is in the hashmp
            // it means a previous prefix sum has the same mod when divided by k
            // it means sum - prefix sum can the a multiple of k
            int mod = sum % k;
            if(map.containsKey(mod)){
                //check it the size of subarray is at least two, i is the larger index
                if(i - map.get(mod) > 1){
                    return true;
                }
            }
            // no need to update the eixsting entry in hashmap
            // the index should be the first showing up in the nums array
            else{
                map.put(mod, i);
            }
        }
        return false;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {0,1,0,3,0,4,0,4,0};
        System.out.println("result: " + m.checkSubarraySum(nums, 5));
	}
}