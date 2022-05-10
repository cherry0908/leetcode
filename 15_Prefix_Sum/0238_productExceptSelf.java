import java.util.*;
public class Main
{
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        if(nums == null || len == 0) return result;
        // two-way prefix product
        int[] prefixL = new int[len];
        int[] prefixR = new int[len];
        prefixL[0] = nums[0];
        prefixR[len - 1] = nums[len - 1];
        for(int i = 1; i < len; i++){
            prefixL[i] = prefixL[i - 1] * nums[i];
        }
        for(int i = len - 2; i >= 0; i--){
            prefixR[i] = prefixR[i + 1] * nums[i];
        }
        result[0] = prefixR[1];
        result[len - 1] = prefixL[len - 2];
        for(int i = 1;i < len - 1; i++){
            result[i] = prefixL[i - 1] * prefixR[i + 1];
        }
        return result;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {1,2,3,4};
        int len = nums.length;
        int[] result = new int[len];
        System.out.println("result: " + Arrays.toString(m.productExceptSelf(nums)));
	}
}