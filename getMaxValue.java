import java.util.*;

class Solution {
    /**
     * @param k1: The coefficient of A
     * @param k2: The  coefficient of B
     * @param c: The volume of backpack
     * @param n: The amount of A
     * @param m: The amount of B
     * @param a: The volume of A
     * @param b: The volume of B
     * @return: Return the max value you can get
     */
    long[][] f;
    boolean[][] done;
    long[] aSum;
    long[] bSum;
    long T,K1,K2,result;
    
    public void calc(int i, int j){
        if(done[i][j]==true) return;
        done[i][j]=true;
        if(i==0&&j==0){
            f[i][j]=0;
            return;
        }
        long total=aSum[i]+bSum[j];
        if(T-total<0){
            f[i][j]=0;
            return;
        }
        if(i>0){
            calc(i-1,j);
            f[i][j]=Math.max(f[i][j],f[i-1][j]+K1*(T-total));
        }
        if(j>0){
            calc(i,j-1);
            f[i][j]=Math.max(f[i][j],f[i][j-1]+K2*(T-total));
        }
        result=Math.max(result, f[i][j]);
    }
     
    public long getMaxValue(int k1, int k2, int c, int n, int m, int[] a, int[] b) {
        f=new long[n+1][m+1];
        done=new boolean[n+1][m+1];
        aSum=new long[n+1];
        bSum=new long[m+1];
        result=0;
        T=c;
        K1=k1;
        K2=k2;
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        //prefix sum for a
        aSum[0]=0;
        for(int i=1;i<=n;i++){
            aSum[i]=aSum[i-1]+a[i-1];
        }
        //prefix sum for bSum
        bSum[0]=0;
        for(int i=1;i<=m;i++){
            bSum[i]=bSum[i-1]+b[i-1];
        }
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                done[i][j]=false;
            }
        }
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                //first i A items, first j B items
                calc(i,j); 
            }
        }
        
        return result;
    }

    public long getMaxValue1(int k1, int k2, int c, int n, int m, int[] a, int[] b) {
        long[][] f=new long[n+1][m+1];
        long[] aSum=new long[n+1];
        long[] bSum=new long[m+1];
        long result=0, total;
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        //prefix sum for a
        aSum[0]=0;
        for(int i=1;i<=n;i++){
            aSum[i]=aSum[i-1]+a[i-1];
        }
        //prefix sum for bSum
        bSum[0]=0;
        for(int i=1;i<=m;i++){
            bSum[i]=bSum[i-1]+b[i-1];
        }
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                //first i A items, first j B items
                if(i==0&&j==0){
                    f[i][j]=0;
                    continue;
                } 
                total=aSum[i]+bSum[j];
                if(c-total<0){
                    f[i][j]=0;
                    continue;
                }
                if(i>0){
                    f[i][j]=Math.max(f[i][j],f[i-1][j]+k1*(c-total));
                }
                if(j>0){
                    f[i][j]=Math.max(f[i][j],f[i][j-1]+k2*(c-total));
                }
                result=Math.max(result, f[i][j]);
            }
        }
        
        return result;
    }
}

public class Main
{
    public static void main(String[] args) {
	    Solution obj = new Solution();
	    int[] a = {4,3};
        int[] b = {1,3,2};
        System.out.println("List: " + obj.getMaxValue(3,2,7,2,3,nums));
	}
}