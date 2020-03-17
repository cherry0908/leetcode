import java.util.*;

class Solution {
    public int numWays(int n, int k) {
        if(n<=0||k<=0) return 0;
        int[][] f=new int[n][2];
        if(n==1) return k;
        //1st post
        f[0][0]=k;//same color
        f[0][1]=k;//different color
        //2rd post
        f[1][0]=k;
        f[1][1]=k*(k-1);
        for(int i=2;i<n;i++){
            f[i][0]=f[i-1][1];//same color
            f[i][1]=(f[i-1][0]+f[i-1][1])*(k-1);//different color
        }
        return f[n-1][0]+f[n-1][1];
    }

    public int numWaysOptimize(int n, int k) {
        if(n<=0||k<=0) return 0;
        if(n==1) return k;

        int sameColorLastTwo = k;
        int diffColorLastTwo = k*(k-1);
        for(int i=2;i<n;i++){
            int tmp = diffColorLastTwo;
            diffColorLastTwo = (sameColorLastTwo+tmp)*(k-1);
            sameColorLastTwo = tmp;
            //f[i][0]=f[i-1][1];//same color
            //f[i][1]=(f[i-1][0]+f[i-1][1])*(k-1);//different color
        }
        return sameColorLastTwo+diffColorLastTwo;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println("result: " + obj.numWays(3,2));
	}
}
