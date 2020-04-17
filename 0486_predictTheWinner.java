class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean PredictTheWinner(int[] nums) {
        if(nums==null||nums.length==0) return true;
        int n=nums.length;
        int[][] f=new int[n][n];
        for(int i=0;i<n;i++) f[i][i]=nums[i];
        
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                f[i][j]=Math.max(nums[i]-f[i+1][j],nums[j]-f[i][j-1]);
            }
        }
        
        if(f[0][n-1]>=0) return true;
        else return false;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={3,2,2};
        System.out.println("result: " + obj.PredictTheWinner(nums));
	}
}