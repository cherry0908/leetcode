/* 
15. 3Sum
Medium
https://leetcode.com/problems/3sum/

Note:
The solution set must not contain duplicate triplets.

*/

import java.io.*; 
import java.util.*;

class Solution {
    // public List<List<Integer>> threeSum(int[] nums) {
    //     List<List<Integer>> list = new ArrayList<List<Integer>>();
    //     if(nums == null || nums.length == 0) return list;
    //     int n = nums.length;
    //     Arrays.sort(nums);
    //     for(int i = 0; i < n; i++){
    //         int target = 0 - nums[i];
    //         int start = i + 1, end = n - 1;
    //         while(start < end){
    //             if(nums[start] + nums[end] == target){
    //                 List<Integer> triplets = new ArrayList<Integer>();
    //                 triplets.add(nums[i]);
    //                 triplets.add(nums[start]);
    //                 triplets.add(nums[end]);
    //                 System.out.println(triplets);
    //                 list.add(triplets);
    //                 start ++;
    //                 end --;
    //                 while(start < end && nums[start] == nums[start - 1]){
    //                     start ++;
    //                 }
    //                 while(start < end && nums[end] == nums[end + 1]){
    //                     end --;
    //                 }
    //             }
    //             else if(nums[start] + nums[end] > target){
    //                 end --;
    //             }
    //             else{
    //                 start ++;
    //             }
    //         }
    //         while(i < n - 1 && nums[i] == nums[i + 1]) {
    //             i ++;
    //         }
    //     }
    //     return list;
    // }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return list;
        int n = nums.length;
        //use hashset to avoid duplicates
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<List<Integer>> result = new HashSet<List<Integer>>();
        //use hashmap to find the target - nums1 - nums2
        //hashmap usage is similar to two sum
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            //add, skip duplicate
            //if true means not in the set yet
            if(set.add(nums[i])){
                //start from i + 1
                for(int j = i + 1; j < n; j++){
                    int rest = 0 - (nums[i] + nums[j]);
                    //if rest is in the map && the number can be used in this loop
                    if(map.containsKey(rest) && map.get(rest) == i){
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], rest);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                    else{
                        map.put(nums[j], i);
                    }
                }
            }
        }
        return new ArrayList(result);
    }
}