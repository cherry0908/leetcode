import java.util.*;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost==null||cost.length==0)return 0;
        int n=cost.length;
        int[] f=new int[n+1];
        f[0]=0;
        f[1]=0;
        for(int i=2;i<=n;i++){
            f[i]=Math.min(f[i-1]+cost[i-1],f[i-2]+cost[i-2]);
        }
        return f[n];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("result: " + obj.minCostClimbingStairs(nums));
	}
}
