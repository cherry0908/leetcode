import java.util.*;

class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null||p==null) return false;
        int slen=s.length();
        int plen=p.length();
        boolean[][] f=new boolean[slen+1][plen+1];
        
        for(int i=0;i<=slen;i++){
            for(int j=0;j<=plen;j++){
                if(i==0&&j==0){
                    f[i][j]=true;
                    continue;
                }
                if(j==0){
                    f[i][j]=false;
                    continue;
                }
                //j>0
                f[i][j]=false;
                if(p.charAt(j-1)!='*'){
                    if(i>0&&(p.charAt(j-1)=='?'||p.charAt(j-1)==s.charAt(i-1))){
                        f[i][j]=f[i-1][j-1];
                    }
                }
                else{
                    //* represents 0 character
                    f[i][j]=f[i][j-1];
                    //* represents 1 or more characters
                    if(i>0){
                        f[i][j]=f[i][j]||f[i-1][j];
                    }
                }
            }
        }
        return f[slen][plen];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String a="cb";
        String b="?a";
        System.out.println("result: " + obj.isMatch(a,b));
	}
}