class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        if(A==null||A.length==0||m==0) return 0;
        
        int n=A.length;
        boolean[][] f=new boolean[n+1][m+1];
        //initialization
        f[0][0]=true;
        for(int w=1;w<=m;w++){
            f[0][w]=false;
        }
        
        //first i items
        for(int i=1;i<=n;i++){
            //can be total weight m
            for(int w=0;w<=m;w++){
                //case 1: not using itme [i-1]
                f[i][w]=f[i-1][w];
                //case 1: adding item [i-1] to the total weight
                if(w-A[i-1]>=0){
                    f[i][w]=f[i][w]||f[i-1][w-A[i-1]];
                }
            }
        }
        
        for(int w=m;w>=0;w--){
            if(f[n][w]==true) {
                return w;
            }
        }
        
        return 0;
    }

    public int backPackOptimized(int m, int[] A) {
        if(A==null||A.length==0||m==0) return 0;
        
        int n=A.length;
        boolean[][] f=new boolean[2][m+1];
        //initialization
        f[0][0]=true;
        for(int w=1;w<=m;w++){
            f[0][w]=false;
        }
        int old, now=0;
        //first i items
        for(int i=1;i<=n;i++){
            old=now;
            now=1-now;
            //can be total weight m
            for(int w=0;w<=m;w++){
                //case 1: not using itme [i-1]
                f[now][w]=f[old][w];
                //case 1: adding item [i-1] to the total weight
                if(w-A[i-1]>=0){
                    f[now][w]=f[now][w]||f[old][w-A[i-1]];
                }
            }
        }
        
        for(int w=m;w>=0;w--){
            if(f[now][w]==true) {
                return w;
            }
        }
        
        return 0;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={3,4,8,5};
        System.out.println("result: " + obj.backPack(10,nums));
	}
}