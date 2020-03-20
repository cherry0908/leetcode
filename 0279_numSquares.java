import java.util.*;

class Solution {
    public int numSquares(int n) {
        if(n<=0) return 0;
        int[] f=new int[n+1];
        f[0]=0;
        for(int i=1;i<n+1;i++){
            f[i]=Integer.MAX_VALUE;
            //last perfect square is j*J
            for(int j=1;j*j<=i;j++){
                f[i]=Math.min(f[i], f[i-j*j]+1);
                System.out.println(f[i]);
            }
            System.out.println(Arrays.toString(f));
        }
        return f[n];
    }
}
public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println("result: " + obj.numSquares(12));
	}
}