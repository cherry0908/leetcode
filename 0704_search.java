import java.util.*;

class Solution {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        if(target<nums[0]||target>nums[nums.length-1]) return -1;
        int median=0, start=0, end=nums.length-1;
        while(start<=end){
            median=(start+end)/2;
            if(target==nums[median]) return median;
            else if(target>nums[median]) start=median+1;
            else end=median-1;
        }
        return -1;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={1,2,4,6,7,9,10};
        System.out.println("result: " + obj.search(nums, 4));
        
	}
}
