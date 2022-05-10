import java.util.*;
public class Main
{
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        if(nums == null || len == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < len; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < len; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                int index = map.get(diff);
                if(index == i) {
                    continue;
                }
                else{
                    result[0] = i;
                    result[1] = index;
                }
                return result;
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        if(nums == null || len == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < len; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                int index = map.get(diff);
                if(index == i){
                    continue;
                }
                else{
                    result[0] = i;
                    result[1] = index;
                }
                return result;
            }
        }
        return null;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {3, 2, 4};
	    int[] nums2 = {2, 7, 11, 15};
	    int[] r = m.twoSum2(nums, 6);
        System.out.println(r[0] + ", " + r[1]);
        r = m.twoSum2(nums2, 9);
        System.out.println(r[0] + ", " + r[1]);
	}
}