import java.util.*;
import java.util.Arrays;

public class Main
{
    public boolean dfs(int[] nums, int target, int start, int curSum, int count, boolean[] visited){
        if(count == 2 && curSum == 0)return true;
        if(curSum>target) return false;
        if(curSum==target) return dfs(nums, target, 0, 0, count+1, visited);
        for(int i=start;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                if(dfs(nums, target, i+1, curSum+nums[i],count, visited)) return true;
                visited[i]=false;
            }
        }
        return false;
    }
    
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int a = 0;
        for(int i : nums) a+=i;
        if(a%2!=0)return false;
        boolean[] visited = new boolean[nums.length];

        return dfs(nums, a/2, 0, 0, 0, visited);
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {1, 5, 11, 5};
        System.out.println("result: " + m.canPartition(nums));
	}
}
