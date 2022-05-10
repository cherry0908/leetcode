import java.util.*;
public class Main
{
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if(nums == null | len < 3) return 0;
        int ptrL, ptrR, result = 0, dist = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < len; i ++){
            ptrL = i + 1;
            ptrR = len - 1;
            while(ptrL < ptrR){
                int sum = nums[i] + nums[ptrL] + nums[ptrR];
                int tmp = Math.abs(target - sum);
                if(sum == target){
                    return sum;
                }
                if(tmp < dist){
                    dist = tmp;
                    result = sum;
                }
                if(sum < target){
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
	    int[] nums = {0, 2, 1, -3};
        System.out.println("result: " + m.threeSumClosest(nums, 1));
	}
}