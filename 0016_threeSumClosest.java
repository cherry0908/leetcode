import java.util.*;
public class Main
{
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null||nums.length<3) return 0;
        int diff=Integer.MAX_VALUE, result=0;
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-3;i++){
            int start=i+1, end=nums.length-1;
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum==target) return sum;
                int tmp = Math.abs(target-sum);
                if(tmp<diff){
                    diff=tmp;
                    result = sum;
                }
                if(sum>target){
                    end--;
                }
                else{
                    start++;
                }
            }
        }
        return result;
    }
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {0,2,1,-3};
        System.out.println("result: " + m.threeSumClosest(nums,1));
	}
}