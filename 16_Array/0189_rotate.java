import java.util.*;

public class Solution{
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return;
        
        int n = nums.length;
        int[] newNums = new int[n];
        int x = k % n;
        
        for (int i = 0; i < n; i++) {
            newNums[(i + x) % n] = nums[i];
        }
        
        for (int i = 0; i < n; i++) {
            nums[i] = newNums[i];
        }
        
        return;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
        
        return;
    }
    
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return;
        
        int n = nums.length;
        int x = k % n;
        
        reverse(nums, 0, n - 1);
        reverse(nums, 0, x - 1);
        reverse(nums, x, n - 1);
        
        return;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,4,5,6,7};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println("");
        s.rotate(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println("");
    }
}