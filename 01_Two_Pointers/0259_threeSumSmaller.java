import java.util.*;
public class Main
{
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        if(nums == null | len < 3) return 0;
        Arrays.sort(nums);
        int ptrL, ptrR, sum, result = 0;
        for(int i = 0; i < len - 1; i++){
            ptrL = i + 1;
            ptrR = len - 1;
            while(ptrL < ptrR){
                sum = nums[i] + nums[ptrL] + nums[ptrR];
                if(sum < target){
                    result = result + (ptrR - ptrL);
                    ptrL++;
                }
                else{
                    ptrR--;
                }
            }
        }
        return result;
    }
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {0, -2, 1, 3};
        System.out.println("result: " + m.threeSumSmaller(nums, 2));
	}
}