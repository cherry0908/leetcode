class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        if(A==null||A.length==0||V==null||V.length==0||m<0) return 0;
        int n=A.length;
        int[][] f=new int[n+1][m+1];
        f[0][0]=0;
        // the fisrt 0th item can not have total weight > 0th
        // use -1 to represent
        for(int j=1;j<=m;j++){
            f[0][j]=-1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                // one way is to not add itself to the total weight and use the weight of i-1
                f[i][j]=f[i-1][j];
                // second way is to add itself
                if(j-A[i-1]>=0&&f[i-1][j-A[i-1]]!=-1){
                    f[i][j]=Math.max(f[i][j],f[i-1][j-A[i-1]]+V[i-1]);
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

    public int backPackIIOptimized(int m, int[] A, int[] V) {
        if(A==null||A.length==0||V==null||V.length==0||m<0) return 0;
        int n=A.length;
        int[][] f=new int[2][m+1];
        f[0][0]=0;
        // the fisrt 0th item can not have total weight > 0th
        // use -1 to represent
        for(int j=1;j<=m;j++){
            f[0][j]=-1;
        }
        int old, now=0;
        
        for(int i=1;i<=n;i++){
            old=now;
            now=1-now;
            for(int j=0;j<=m;j++){
                // one way is to not add itself to the total weight and use the weight of i-1
                f[now][j]=f[old][j];
                // second way is to add itself
                if(j-A[i-1]>=0&&f[old][j-A[i-1]]!=-1){
                    f[now][j]=Math.max(f[now][j],f[old][j-A[i-1]]+V[i-1]);
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

    public int backPackIIPrintOut(int m, int[] A, int[] V) {
        if(A==null||A.length==0||V==null||V.length==0||m<0) return 0;
        int n=A.length;
        int[][] f=new int[n+1][m+1];
        int[][] pi=new int[n+1][m+2];
        f[0][0]=0;
        // the fisrt 0th item can not have total weight > 0th
        // use -1 to represent
        for(int j=1;j<=m;j++){
            f[0][j]=-1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                // one way is to not add itself to the total weight and use the weight of i-1
                f[i][j]=f[i-1][j];
                //did not choose this item
                pi[i][j]=0;
                // second way is to add itself
                if(j-A[i-1]>=0&&f[i-1][j-A[i-1]]!=-1){
                    f[i][j]=Math.max(f[i][j],f[i-1][j-A[i-1]]+V[i-1]);
                    //chose this item
                    if(f[i][j]==f[i-1][j-A[i-1]]+V[i-1]){
                        pi[i][j]=1;
                    }
                }
            }
        }
        
        int result=Integer.MIN_VALUE;
        int w=0;
        for(int j=0;j<=m;j++){
            if(f[n][j]!=-1){
                result=Math.max(result,f[n][j]);
                if(result==f[n][j]){
                    w=j;
                }
            }
        }
        
        //total weight is f[n][w]
        //A[0]...A[n-1], selected is used to remember which items are selected
        boolean[] selected = new boolean[n];
        //from the end to the start
        for(int i=n;i>0;i--){
            //start from f[i][w], the total weight of the result
            if(pi[i][w]==1){
                selected[i-1]=true;
                w=w-A[i-1];
            }else{
                selected[i-1]=false;
            }
        }
        
        for(int i=0;i<n;i++){
            if(selected[i]) System.out.println("Item: "+i+" weight:"+A[i]+" value: "+V[i]);
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
        System.out.println("result: " + obj.backPackII(11,w,v));
	}
}