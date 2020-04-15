import java.util.*;
class Solution {
    
    public void backtrack(List<List<Integer>> result, int index, List<Integer> current, int[] nums, int target){
        if(index == nums.length){
            int sum=0;
            for(int i=0;i<current.size();i++){
                sum+=current.get(i);
            }
            if(sum==target){
                ArrayList<Integer> temp = new ArrayList<Integer>(current);
	            result.add(temp);
            }
            return;
        } 
        
        current.add(nums[index]);
        backtrack(result, index+1, current, nums, target);
        current.remove(current.size()-1);
        
        current.add(nums[index]*(-1));
        backtrack(result, index+1, current, nums, target);
        current.remove(current.size()-1);
    }
    //Print all combination, Time Limit Exceeded
    public int findTargetSumWaysTLE(int[] nums, int S) {
        if(nums==null||nums.length==0) return 0;
        int result=0;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        backtrack(list, 0, current, nums, S);
        for(int i=0;i<list.size();i++){
            result++;
        }
        return result;
    }

    // Solution 1: DFS
    int count = 0;
    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    // Solution 1: Dynamic Programming T: O(ns), S: O(ns)
    public int findTargetSumWays(int[] nums, int S) {
        if(nums==null||nums.length==0) return 0;
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        //out of boundary
        if(S>sum||S<sum*(-1)) return 0;
        
        int offset=sum;
        int s=sum+1+offset;
        //initialization
        //target num is from -sum...0...sum
        //total is sum*2+1
        int[][] f=new int[n+1][s];
        for(int j=0;j<s;j++){
            f[0][j]=0;
        }
        f[0][offset]=1;
        //first i nums sum up to j
        for(int i=1;i<=n;i++){
            for(int j=0;j<s;j++){
                f[i][j]=0;
                if(j-nums[i-1]>=0&&j-nums[i-1]<s){
                    f[i][j]=f[i][j]+f[i-1][j-nums[i-1]];
                }
                if(j+nums[i-1]>=0&&j+nums[i-1]<s){
                    f[i][j]=f[i][j]+f[i-1][j+nums[i-1]];
                }
            }
        }
        return f[n][S+offset];
    }

    // Solution 2: with rolling array Space: O(S)
    public int findTargetSumWaysOpt(int[] nums, int S) {
        if(nums==null||nums.length==0) return 0;
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int offset=sum;
        int s=sum+1+offset;
        if(S>sum||S<sum*(-1)) return 0;
        //initialization
        //target num is from -sum...0...sum
        //total is sum*2+1
        int[][] f=new int[2][s];
        for(int j=0;j<s;j++){
            f[0][j]=0;
        }
        f[0][offset]=1;
        int old, now=0;
        //first i nums sum up to j
        for(int i=1;i<=n;i++){
            old=now;
            now=1-now;
            for(int j=0;j<s;j++){
                f[now][j]=0;
                if(j-nums[i-1]>=0&&j-nums[i-1]<s){
                    f[now][j]=f[now][j]+f[old][j-nums[i-1]];
                }
                if(j+nums[i-1]>=0&&j+nums[i-1]<s){
                    f[now][j]=f[now][j]+f[old][j+nums[i-1]];
                }
            }
        }
        return f[now][S+offset];
    }

    // Solution 3: linear array

}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={1,1,1,1,1};
        System.out.println("result: " + obj.findTargetSumWays(nums, 3));
	}
}


