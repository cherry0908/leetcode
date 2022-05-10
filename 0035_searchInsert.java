import java.util.*;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(nums == null || len == 0) return 0;
        int start = 0, end = len - 1, index = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target < nums[mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return end + 1;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={1,3,5,6};
        System.out.println("result: " + obj.searchInsert(nums, 7));
        
	}
}
