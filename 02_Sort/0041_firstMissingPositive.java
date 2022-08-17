import java.util.*;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        
        // we only care about positive numbers
        // starts with 1 to n
        // nums[0] = 1, nums[1] = 2 ... nums[i] = i + 1
        // x should be on the position of nums[x - 1]
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // if the current number is within the range of 1 to n and it not in the correct position
            // swap the current to the current position nums[current - 1]
						// swap once if nums[i] is still not in the correct position, keep swapping
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // swap the two numbers
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return n + 1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,4,-1,1};
        int r = s.firstMissingPositive(nums);
        System.out.println(r);
    }
}