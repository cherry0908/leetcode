/*
33. Search in Rotated Sorted Array
https://leetcode.com/problems/search-in-rotated-sorted-array/

Constraints:s
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
All values of nums are unique.
nums is guranteed to be rotated at some pivot.
-10^4 <= target <= 10^4
 */

import java.io.*; 
import java.util.*;

class Solution {
//     public int search(int[] nums, int target) {
//         if(nums == null || nums.length == 0) return -1;
//         int start = 0, end = nums.length - 1;
//         while(start <= end){
//             int mid = start + (end - start) / 2;
//             if(nums[mid] == target){
//                 return mid;
//             }
//             //left is sorted
//             if(nums[start] <= nums[mid]){
//                 //target is in the left part
//                 if(target >= nums[start] && target <= nums[mid]){
//                     end = mid - 1;
//                 }
//                 else{
//                     start = mid + 1;
//                 }
//             }
//             //right is sorted
//             else{
//                 //target is in the right part
//                 if(target >= nums[mid] && target <= nums[end]){
//                     start = mid + 1;
//                 }
//                 else{
//                     end = mid - 1;
//                 }
//             }
//         }
//         return -1;
//     }
    
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //left is sorted
            if (nums[start] < nums[mid]) {
                //target is in the left part
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } 
            //right is sorted
            else {
                //target is in the right part
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
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

