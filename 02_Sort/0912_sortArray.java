/*
912. Sort an Array
https://leetcode.com/problems/sort-an-array/

Constraints:
1 <= nums.length <= 50000
-50000 <= nums[i] <= 50000

*/

import java.io.*; 
import java.util.*;

class Solution {
    //quick sort
    // public int[] quickSort(int[] nums, int start, int end){
    //     if(start >= end) return nums;
    //     //step 1: select a pivot, usually the middle one
    //     int pivot = nums[(start + end)/2];
    //     int left = start, right = end;
    //     //step 2: swap if not in the correct partition
    //     while(left <= right){
    //         //To keep balance, if nums[left] == pivot or nums[right] == pivot, swap too
    //         //skip the correct one
    //         while(left <= right && nums[left] < pivot){
    //             left++;
    //         }
    //         while(left <= right && nums[right] > pivot){
    //             right--;
    //         }
    //         //swap the left and right
    //         if(left <= right){
    //             int tmp = nums[left];
    //             nums[left] = nums[right];
    //             nums[right] = tmp;
    //             left++;
    //             right--;
    //         }
    //     }
    //     //divide and conquer
    //     //do quicksort on the left part and right part
    //     quickSort(nums, start, right);
    //     quickSort(nums, left, end);
    //     return nums;
    // }
    
    //merge sort
    public void merge(int[] nums, int start, int mid, int end, int[] tmp){
        int leftIdx = start, rightIdx = mid + 1, idx = start;
        while(leftIdx <= mid && rightIdx <= end){
            if(nums[leftIdx] <= nums[rightIdx]){
                tmp[idx] = nums[leftIdx];
                leftIdx++;
                idx++;
            }
            else{
                tmp[idx] = nums[rightIdx];
                rightIdx++;
                idx++;
            }
            
        }
        while(leftIdx <= mid){
            tmp[idx] = nums[leftIdx];
            leftIdx++;
            idx++;
        }
        while(rightIdx <= end){
            tmp[idx] = nums[rightIdx];
            rightIdx++;
            idx++;
        }
        for(int i = start; i <= end; i++){
            nums[i] = tmp[i];
        }
    }
    
    public int[] mergeSort(int[] nums, int start, int end, int[] tmp){
        if(start >= end){
            return nums;
        }
        int mid = (start + end)/2;
        mergeSort(nums, start, mid, tmp);
        mergeSort(nums, mid + 1, end, tmp);
        merge(nums, start, mid, end, tmp);
        return nums;
    }
    
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        //return quickSort(nums, 0, nums.length - 1);
        int[] tmp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1, tmp);
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {2, 5, 13, 1, 9, 6};
        System.out.println("result: " + Arrays.toString(nums));
        int[] result = obj.sortArray(nums);
        System.out.println("result: " + Arrays.toString(result));
	}
}