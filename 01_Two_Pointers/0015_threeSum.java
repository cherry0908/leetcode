/* 
15. 3Sum
Medium
https://leetcode.com/problems/3sum/

Note:
The solution set must not contain duplicate triplets.

*/

import java.io.*; 
import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(nums == null | len < 3) return result;
        Arrays.sort(nums);
        int ptrL, ptrR, sum;
        for(int i = 0; i < len; i ++){
            ptrL = i + 1;
            ptrR = len - 1;
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            while(ptrL < ptrR){
                sum = nums[i] + nums[ptrL] + nums[ptrR];
                if(sum == 0){
                    List<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[ptrL]);
                    triplet.add(nums[ptrR]);
                    result.add(triplet);
                    ptrL++;
                    ptrR--;
                    while(ptrL < ptrR && nums[ptrL] == nums[ptrL - 1]){
                        ptrL++;
                    }
                    while(ptrL < ptrR && nums[ptrR] == nums[ptrR + 1]){
                        ptrR--;
                    }
                }
                else if(sum < 0){
                    ptrL++;
                }
                else{
                    ptrR--;
                }
            }
        }
        return result;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(nums == null | len < 3) return result;
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<List<Integer>> triplets = new HashSet<List<Integer>>();
        for(int j = 0; j < len; j++){
            if(set.contains(nums[j])){
                continue;
            }
            set.add(nums[j]);
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = j + 1; i < len; i++){
                if(!map.containsKey(nums[i])){
                    map.put(nums[i], i);
                }
                int diff = 0 - nums[j] - nums[i];
                if(map.containsKey(diff)){
                    int index = map.get(diff);
                    if(index == i){
                        continue;
                    }
                    else{
                        List<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[index]);
                        Collections.sort(triplet);
                        triplets.add(triplet);
                    }
                }
            }
        }
        result = new ArrayList<>(triplets);
        return result;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[] nums = {-2, 0, 0, 2, 2};
	    List<List<Integer>> r = s.threeSum(nums);
        System.out.println(r);
	}

}