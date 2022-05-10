import java.util.*;
public class Main
{
    public int longestOnes(int[] nums, int k) {
        int len = nums.length;
        if(nums == null || k < 0) return 0;
        int left = 0, cnt = 0, res = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0){
                cnt++;
            }
            while (cnt > k) {
                if (nums[left] == 0){
                    cnt--;
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println("result: " + m.longestOnes(nums, 2));
	}
}