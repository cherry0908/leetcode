import java.util.*;
public class Main
{
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) return 0;
        int sum = 0, result = 0;
        HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for(int i = 0; i < len; i ++){
            if(nums[i] == 0){
                sum = sum - 1;
            }else{
                sum = sum + 1;
            }
            if(map.containsKey(sum)){
                result = Math.max(result, i - map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return result;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {0,1,0};
        System.out.println("result: " + m.findMaxLength(nums));
	}
}