import java.util.*;
public class Main
{
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) return -1;
        int sum = 0, leftSum = 0;
        for(int i = 0; i < len; i++){
            sum = sum + nums[i];
        }
        for(int i = 0; i < len; i++){
            int rightSum = sum - leftSum - nums[i];
            if(rightSum == leftSum){
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {1,7,3,6,5,6};
        System.out.println("result: " + m.pivotIndex(nums));
	}
}