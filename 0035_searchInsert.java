import java.util.*;

class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        if(target<nums[0]) return 0;
        int median=nums.length/2, start=0, end=nums.length-1;
        while(start<=end){
            median=(start+end)/2;
            if(target<nums[median]) end=median-1;
            else if(target>nums[median]) start=median+1;
            else return median;
        }
        return end+1;
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
