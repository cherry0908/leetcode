class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackIII(int m, int[] A, int[] V) {
        if(A==null||A.length==0||V==null||V.length==0||m<0) return 0;
        int n=A.length;
        int[][] f=new int[n+1][m+1];
        f[0][0]=0;
        for(int j=1;j<=m;j++){
            f[0][j]=-1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                f[i][j]=f[i-1][j];
                if(j-A[i-1]>=0&&f[i][j-A[i-1]]!=-1){
                    f[i][j]=Math.max(f[i][j],f[i][j-A[i-1]]+V[i-1]);
                }
            }
        }
        
        int result=Integer.MIN_VALUE;
        for(int j=0;j<=m;j++){
            if(f[n][j]!=-1){
                result=Math.max(result,f[n][j]);
            }
        }
        return result;
    }

    public int backPackIIIOptimized(int m, int[] A, int[] V) {
        if(A==null||A.length==0||V==null||V.length==0||m<0) return 0;
        int n=A.length;
        int[][] f=new int[2][m+1];
        f[0][0]=0;
        for(int j=1;j<=m;j++){
            f[0][j]=-1;
        }
        int old, now=0;
        
        for(int i=1;i<=n;i++){
            old=now;
            now=1-now;
            for(int j=0;j<=m;j++){
                f[now][j]=f[old][j];
                if(j-A[i-1]>=0&&f[now][j-A[i-1]]!=-1){
                    f[now][j]=Math.max(f[now][j],f[now][j-A[i-1]]+V[i-1]);
                }
            }
        }
        
        int result=Integer.MIN_VALUE;
        for(int j=0;j<=m;j++){
            if(f[now][j]!=-1){
                result=Math.max(result,f[now][j]);
            }
        }
        return result;
    }

    public int backPackIIIBest(int[] A, int[] V, int m) {
        if(A==null||A.length==0||V==null||V.length==0||m<0) return 0;
        int n=A.length;
        int[] f=new int[m+1];
        f[0]=0;
        for(int j=1;j<=m;j++){
            f[j]=-1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=A[i-1];j<=m;j++){
                // old value f[i-1][[j]: f[j]
                // new f[i][j-A[i-1]]: f[j-A[i-1]]
                if(f[j-A[i-1]]!=-1){
                    f[j]=Math.max(f[j],f[j-A[i-1]]+V[i-1]);
                }
            }
        }
        
        int result=Integer.MIN_VALUE;
        for(int j=0;j<=m;j++){
            if(f[j]!=-1){
                result=Math.max(result,f[j]);
            }
        }
        return result;
    }
}

    

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] w={2,3,5,7};
        int[] v={1,5,2,4};
        System.out.println("result: " + obj.backPackIII(10,w,v));
	}
}