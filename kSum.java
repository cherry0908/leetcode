import java.util.*;

class Solution {
    /**
     * @param A: An integer array
     * @param k: A positive integer (k <= length(A))
     * @param target: An integer
     * @return: An integer
     */
    public int kSum(int[] A, int k, int target) {
        if(A==null||A.length==0) return 0;
        int n=A.length;
        int[][][] f=new int[n+1][k+1][target+1];
        for(int j=0;j<=k;j++){
            for(int t=0;t<=target;t++){
                f[0][j][t]=0;
            }
        }
        f[0][0][0]=1;
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){
                for(int t=0;t<=target;t++){
                    f[i][j][t]=f[i-1][j][t];
                    if(j>=1&&t>=A[i-1]){
                        f[i][j][t]=f[i][j][t]+f[i-1][j-1][t-A[i-1]];
                    }
                }
            }
        }
        
        return f[n][k][target];
    }
}

public class Main
{
    public static void main(String[] args) {
	    Solution obj = new Solution();
	    int[] nums = {1,2,3,4};
        System.out.println("List: " + obj.kSum(nums,2,5));
	}
}