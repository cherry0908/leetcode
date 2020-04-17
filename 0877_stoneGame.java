class Solution {
    public boolean stoneGame(int[] piles) {
        if(piles==null||piles.length==0) return true;
        int n=piles.length;
        int[][] f=new int[n][n];
        for(int i=0;i<n;i++) f[i][i]=piles[i];
        
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                f[i][j]=Math.max(piles[i]-f[i+1][j],piles[j]-f[i][j-1]);
            }
        }
        
        if(f[0][n-1]>0) return true;
        else return false;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={5,3,4,5};
        System.out.println("result: " + obj.stoneGame(nums));
	}
}