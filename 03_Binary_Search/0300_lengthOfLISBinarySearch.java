import java.util.*;

class Solution {
    
    public int search(int num, ArrayList<Integer> sub) {
        int start = 0;
        int end = sub.size() - 1;
        
        while(start < end) {
            int mid = start + (end - start) / 2;
            
            if(sub.get(mid) == num) {
                return mid;
            }
            else if (sub.get(mid) < num) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        } 
        
        return start;
    }
    
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n= nums.length;
        int result = 1;
        
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for (int i = 1; i < n; i++) {
            int size = sub.size();
            
            if (nums[i] > sub.get(size - 1)) {
                sub.add(nums[i]);
            }
            else {
                // do a binary search in sub array 
                // find the smallest element that is greater than or equal to nums[i]
                int index = search(nums[i], sub);
                sub.set(index, nums[i]);
            }
        }
        
        return sub.size();
    }
}


public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println("result: " + obj.lengthOfLIS(nums));
	}
}