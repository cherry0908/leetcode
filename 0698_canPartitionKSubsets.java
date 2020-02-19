import java.util.*;
import java.util.Arrays;

public class Main
{
    public boolean dfs(int[] nums, int k, int target, int start, int curSum, int count, boolean[] visited){
        if(count == k && curSum == 0)return true;
        if(curSum>target) return false;
        if(curSum==target) return dfs(nums, k, target, 0, 0, count+1, visited);
        for(int i=start;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                if(dfs(nums, k, target, i+1, curSum+nums[i],count, visited)) return true;
                visited[i]=false;
            }
        }
        return false;
    }
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0, target;
        for(int num : nums) sum+=num;
        if(sum%k != 0) return false;
        target = sum/k;
        //Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        for(boolean i : visited) i=false;
        
        return dfs(nums, k, target, 0, 0, 0, visited);
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println("result: " + m.canPartitionKSubsets(nums, 4));
	}
}
