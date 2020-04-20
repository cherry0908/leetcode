import java.util.*;

class Solution {
    public int numDistinct(String s, String t) {
        if(s==null||t==null) return 0;
        int slen=s.length();
        int tlen=t.length();
        if(slen==0) return 0;
        
        int[][] f=new int[slen+1][tlen+1];
        f[0][0]=1;
        for(int j=1;j<=tlen;j++){
            f[0][j]=0;
        }
        for(int i=1;i<=slen;i++){
            f[i][0]=1;
        }
        
        for(int i=1;i<=slen;i++){
            for(int j=1;j<=tlen;j++){
                f[i][j]=f[i-1][j];
                if(s.charAt(i-1)==t.charAt(j-1)){
                    f[i][j]=f[i][j]+f[i-1][j-1];
                }
            }
        }
        
        return f[slen][tlen];
    }
}

public class Main
{
	public static void main(String[] args) {
	    Solution obj = new Solution();
	    String a="rabbbit";
        String b="rabbit";
		System.out.println("result: " + obj.numDistinct(a,b));
	}
}