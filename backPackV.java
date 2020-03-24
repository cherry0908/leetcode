class Solution {
    /**
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        if(nums==null||nums.length==0||target==0) return 0;
        
        int n=nums.length;
        int[][] f=new int[n+1][target+1];
        
        //initialization
        f[0][0]=1;
        for(int t=1;t<=target;t++){
            f[0][t]=0;
        }
        
        for(int i=1;i<=n;i++){
            for(int t=0;t<=target;t++){
                f[i][t]=f[i-1][t];
                if(t-nums[i-1]>=0){
                    f[i][t]+=f[i-1][t-nums[i-1]];
                }
            }
        }
        
        return f[n][target];
    }

    public int backPackVOptimized(int[] nums, int target) {
        if(nums==null||nums.length==0||target==0) return 0;
        
        int n=nums.length;
        int[][] f=new int[n+1][target+1];
        int old, now=0;
        
        //initialization
        f[0][0]=1;
        for(int t=1;t<=target;t++){
            f[0][t]=0;
        }
        
        for(int i=1;i<=n;i++){
            old=now;
            now=1-now;
            for(int t=0;t<=target;t++){
                f[now][t]=f[old][t];
                if(t-nums[i-1]>=0){
                    f[now][t]+=f[old][t-nums[i-1]];
                }
            }
        }
        
        return f[now][target];
    }

    public int backPackVOptimized2(int[] nums, int target) {
        if(nums==null||nums.length==0||target==0) return 0;
        
        int n=nums.length;
        int[] f=new int[target+1];
        
        //initialization
        f[0]=1;
        for(int t=1;t<=target;t++){
            f[t]=0;
        }
        
        for(int i=1;i<=n;i++){
            //t不用循环到0，到nums[i-1]，只有正上方，左上方已经越界小于0
            for(int t=target;t>=nums[i-1];t--){
                //t只到t>=nums[i-1]，不需要再用if判断越界
                //f[t-nums[i-1]]是前一行old值，加起来覆盖new的值
                f[t]+=f[t-nums[i-1]];
            }
        }
        
        return f[target];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={1,2,3,3,7};
        System.out.println("result: " + obj.backPackV(nums,7));
	}
}