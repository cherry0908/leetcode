import java.util.*;

class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        if(n==0) return false;
        if(n==1||n==2) return true;
        boolean[] f=new boolean[n+1];
        f[0]=false;
        f[1]=true;
        f[2]=true;
        for(int i=2;i<n+1;i++){
            f[i]=(f[i-1]==false||f[i-2]==false);
        }
        return f[n];
    }

    public boolean firstWillWinOptimized(int n) {
        return n%3!=0;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println("result: " + obj.firstWillWin(11));
	}
}