import java.util.*;

public class Solution {
    public int findDuplicate1(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        // no modifying array, so no sorting the array O(nlogn)
        // no extra space, so no hashset O(n)
        // linear running time, so no brute force O(n^2)
        
        // [3, 1, 3, 4, 2]
        // we have n + 1 integers where each integer is in the range [1, n]
        // put every number in its own slot
        // where nums[1] = 1, nums[2] = 2, nums[3] = 3, etc
        // nums[0] will have the only duplicate
        // every compare nums[0] and nums[nums[0]]
        // if not swap, if equal, this is the duplicate
        
        while (nums[0] != nums[nums[0]]) {
            int tmp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = tmp;
        }
        
        // [3, 1, 3, 4, 2] nums[0] = 3, nums[3] = 4, swap
        // [4, 1, 3, 3, 2] nums[0] = 4, nums[4] = 2, swap
        // [2, 1, 3, 3, 4] nums[0] = 2, nums[2] = 3, swap
        // [3, 1, 2, 3, 4] nums[0] = 3, nums[3] = 3, duplicate
        
        return nums[0];
    }

    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        // one duplicate in the array
        // means the array can form a cycle
        // the duplicate is the intersection of the cycle
        // use two pointer to find the indersection in the cycle
        
        int n = nums.length;
        int slow = 0, fast = 0, index = -1;
        
        // [3,1,3,4,2]
        // 3 -> 4 -> 2 -> 3
        while (fast < n && nums[fast] < n) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            
            if(slow == fast) {
                index = slow;
                break;
            }
        }
        
        
        if (index == -1) return -1;
        
        int start = 0;
        
        while (start != slow) {
            start = nums[start];
            slow = nums[slow];
        }
        
        return start;
    }

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        
        int n = nums.length;
        
        // based on nums containing n + 1 integers 
        // where each integer is in the range [1, n] inclusive
        // we use index to do binary search
        // if there's no duplicate, each index has one number exclusive
        
        int start = 1, end = n - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = 0;
            
            // calculate the count of nums in the array that is smaller or equals to mid index
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            
            if (count > mid) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return end + 1;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={3,1,3,2,4};
        System.out.println("result: " + obj.findDuplicate(nums));
	}
}
