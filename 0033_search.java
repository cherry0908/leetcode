import java.util.*;

class Solution {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(target==nums[mid])return mid;
            //left is sorted
            if(nums[mid]>=nums[left]){
                if(target>=nums[left]&&target<=nums[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            //right is sorted
            else{
                if(target>=nums[mid]&&target<=nums[right]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={4,5,6,7,0,1,2};
        System.out.println("result: " + obj.search(nums,0));
	}
}
