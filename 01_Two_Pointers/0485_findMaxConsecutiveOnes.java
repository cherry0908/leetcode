import java.util.*;
public class Main
{
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) return 0;
        int start = 0, end = 0, result = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == 1){
                end++;
            }
            else{
                int tmp = end - start;
                result = Math.max(result, end - start);
                end++;
                start = end;
            }
        }
        if(nums[len - 1] == 1){
            result = Math.max(result, end - start);
        }
        return result;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {1,1,0,1,1,1};
        System.out.println("result: " + m.findMaxConsecutiveOnes(nums));
	}
}