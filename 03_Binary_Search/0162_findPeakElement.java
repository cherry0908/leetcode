import java.util.*;

public class Solution {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return 0;
        
        int n = nums.length;
        int left = 0, right = n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // always look right first
            // because mid = left + (right - left) / 2, it will pick the left one in the middle
            if (mid < n - 1 && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return right + 1;
    }


    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={3,1,3,2,4};
        System.out.println("result: " + obj.findPeakElement(nums));
	}
}
