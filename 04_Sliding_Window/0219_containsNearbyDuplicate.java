import java.util.*;
public class Main
{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        if(nums == null || len == 0) return false;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < len; i++){
            if(map.containsKey(nums[i]))
            {
                return true;
            }
            map.put(nums[i], i);
            if(map.size() > k){
                // remove the oldest element in the map
                // the first element since the window starts
                map.remove(nums[i - k]);
            }
        }
        return false;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {4,1,2,3,1,5};
        System.out.println("result: " + m.containsNearbyDuplicate(nums, 2));
	}
}