import java.util.*;
public class Main
{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null||nums.length<3) return result;
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-3;i++){
            if(i==0||nums[i]!=nums[i-1]){
                int start=i+1, end=nums.length-1;
                while(start<end){
                    int sum = nums[i]+nums[start]+nums[end];
                    if(sum==0){
                        List<Integer> index = new ArrayList<Integer>();
                        index.add(nums[i]);
                        index.add(nums[start]);
                        index.add(nums[end]);
                        result.add(index);
                        start++;
                        end--;
                        while(start<end&&nums[start]==nums[start-1]) start++;
                        while(start<end&&nums[end]==nums[end+1]) end--;
                    }
                    else if(sum>0){
                        end--;
                    }
                    else{
                        start++;
                    }
                }
            }
        }
        return result;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("result: " + m.threeSum(nums));
	}
}