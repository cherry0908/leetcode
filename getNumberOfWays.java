import java.util.*;

class Solution {
    /**
     * @param n: the max identifier of planet.
     * @param m: gold coins that Sven has.
     * @param limit: the max difference.
     * @param cost: the number of gold coins that reaching the planet j through the portal costs.
     * @return: return the number of ways he can reach the planet n through the portal.
     */
    public long getNumberOfWays(int n, int m, int limit, int[] cost) {
        if(cost==null||cost.length==0) return 0;
        
        long[][] f=new long[n+1][m+1];
        for(int i=0;i<m;i++){
            f[0][i]=0;
        }
        f[0][m]=1;
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                f[i][j]=0;
                if(j+cost[i]<=m){
                    for(int k=i-limit;k<=i-1;k++){
                        if(k>=0){
                            f[i][j]=f[i][j]+f[k][j+cost[i]];
                        }
                    }
                }
            }
        }
        
        long result=0;
        for(int i=0;i<=m;i++){
            result=result+f[n][i];
        }
        return result;
    }

    public long getNumberOfWaysOptimized(int n, int m, int limit, int[] cost) {
        if(cost==null||cost.length==0) return 0;
        
        long[][] f=new long[n+1][m+1];
        long[][] sum=new long[n+1][m+1];
        for(int i=0;i<m;i++){
            f[0][i]=0;
            sum[0][i]=0;
        }
        f[0][m]=1;
        sum[0][m]=1;
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                f[i][j]=0;
                sum[i][j]=sum[i-1][j];
                if(j+cost[i]<=m){
                    f[i][j]=sum[i-1][j+cost[i]];
                    if(i-limit-1>=0){
                        f[i][j]=f[i][j]-sum[i-limit-1][j+cost[i]];
                    }
                    sum[i][j]=sum[i][j]+f[i][j];
                    //sum[i][j]=f0][j]+...f[i][j]
                }
                
            }
        }
        
        long result=0;
        for(int i=0;i<=m;i++){
            result=result+f[n][i];
        }
        return result;
    }
}

public class Main
{
    public static void main(String[] args) {
	    Solution obj = new Solution();
	    int[] nums = {0, 1};
        System.out.println("List: " + obj.getNumberOfWays(1,1,1,nums));
	}
}