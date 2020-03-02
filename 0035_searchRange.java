import java.util.*;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range={-1,-1};
        if(nums==null||nums.length==0||target<nums[0]||target>nums[nums.length-1]) return range;
        int median=0, start=0, end=nums.length-1;
        while(start<=end){
            median=(start+end)/2;
            if(target>nums[median])start=median+1;
            else if(target<nums[median])end=median-1;
            else{
                range[0]=median;
                range[1]=median;
                break;
            }
        }
        if(range[0]==-1) return range;
        
        int newStart=median;
        int newEnd=nums.length-1;
        int newMedian=0;
        while(newStart<=newEnd){
            newMedian=(newStart+newEnd)/2;
            if(target==nums[newMedian]){
                newStart=newMedian+1;
            }
            else{
                newEnd=newMedian-1;
            }
        }
        range[1]=newEnd;
        
        newStart=0;
        newEnd=median;
        while(newStart<=newEnd){
            newMedian=(newStart+newEnd)/2;
            if(target==nums[newMedian]){
                newEnd=newMedian-1;
            }
            else{
                newStart=newMedian+1;
            }
        }
        range[0]=newStart;
        
        return range;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={5,7,7,8,10};
        System.out.println("result: " + Arrays. toString(obj.searchRange(nums, 8)));
        
	}
}
