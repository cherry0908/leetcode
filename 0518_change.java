class Solution {
    public int change(int amount, int[] coins) {
        if(amount==0) return 1;
        if(coins==null||coins.length==0) return 0;
        
        
        int n=coins.length;
        int[][] f=new int[n+1][amount+1];
        
        //initialization
        f[0][0]=1;
        for(int j=1;j<=amount;j++){
            f[0][j]=0;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){
                f[i][j]=f[i-1][j];
                int k=1;
                while(coins[i-1]*k<=j){
                    f[i][j]=f[i][j]+f[i-1][j-k*coins[i-1]];
                    k++;
                }
                
            }
        }
        
        return f[n][amount];
    }

    public int changeOptimized1(int amount, int[] coins) {
        if(amount==0) return 1;
        if(coins==null||coins.length==0) return 0;
        int n=coins.length;
        int[][] f=new int[n+1][amount+1];
        
        //initialization
        f[0][0]=1;
        for(int j=1;j<=amount;j++){
            f[0][j]=0;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=amount;j++){
                f[i][j]=f[i-1][j];
                if(j-coins[i-1]>=0){
                    f[i][j]=f[i][j]+f[i][j-coins[i-1]];
                }
            }
        }
        
        return f[n][amount];
    }

    public int changeOptimized2(int amount, int[] coins) {
        if(amount==0) return 1;
        if(coins==null||coins.length==0) return 0;
        
        int n=coins.length;
        int[] f=new int[amount+1];
        
        //initialization
        f[0]=1;
        for(int i=1;i<=amount;i++){
            f[i]=0;
        }
        
        // for(int i=1;i<=n;i++){
        //     for(int j=0;j<=amount;j++){
        //         int old=f[j], now=0;
        //         if(j-coins[i-1]>=0){
        //             now=f[j-coins[i-1]];
        //         }
        //         f[j]=old+now;
        //     }
        // }

        for(int i=1;i<=n;i++){
            for(int j=coins[i-1];j<=amount;j++){
                f[j]=f[j]+f[j-coins[i-1]];
            }
        }
        
        return f[amount];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={1,2,5};
        System.out.println("result: " + obj.change(5,nums));
	}
}