import java.util.*;
public class Main
{
    public int findMaxConsecutiveOnes1(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) return 0;
        int index = 0, start = 0, end = 0, result = 0;
        boolean isFlipped = false;
        for(int i = 0; i < len; i++){
            if(nums[end] == 1){
                end++;
            }
            else if(!isFlipped){
                index = end;
                isFlipped = true;
                end++;
            }
            else{
                result = Math.max(result, end - start);
                start = index + 1;
                index = end;
                end++;
            }
        }
        result = Math.max(result, end - start);
        return result;
    }
    
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) return 0;
        int start = 0, result = 0, zero = 0, k = 1;
        for(int i = 0; i < len; i++){
            if(nums[i] == 0){
                zero++;
            }
            while(zero > k){
                if(nums[start] == 0){
                    zero--;
                }
                start++;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {1,1,0,1};
        System.out.println("result: " + m.findMaxConsecutiveOnes(nums));
	}
}