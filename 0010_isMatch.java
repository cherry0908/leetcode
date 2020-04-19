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
                f[i][j]=false;
                if(p.charAt(j-1)!='*'){
                    if(i>0&&(p.charAt(j-1)=='.'||p.charAt(j-1)==s.charAt(i-1))){
                        f[i][j]=f[i-1][j-1];
                    }
                }
                else{
                    if(j>1){
                        f[i][j]=f[i][j-2];
                    }
                    if(j>1&&i>0&&(p.charAt(j-2)=='.'||p.charAt(j-2)==s.charAt(i-1))){
                        f[i][j]=f[i][j]||f[i-1][j];
                    }
                }
            }
        }
        return f[slen][plen];
    }

    public boolean isMatchOptimiazed(String s, String p) {
        if(s==null||p==null) return false;
        int slen=s.length();
        int plen=p.length();
        boolean[][] f=new boolean[2][plen+1];
        int old, now=0;
        
        for(int i=0;i<=slen;i++){
            old=now;
            now=1-now;
            for(int j=0;j<=plen;j++){
                if(i==0&&j==0){
                    f[now][j]=true;
                    continue;
                }
                if(j==0){
                    f[now][j]=false;
                    continue;
                }
                f[now][j]=false;
                if(p.charAt(j-1)!='*'){
                    if(i>0&&(p.charAt(j-1)=='.'||p.charAt(j-1)==s.charAt(i-1))){
                        f[now][j]=f[old][j-1];
                    }
                }
                else{
                    if(j>1){
                        f[now][j]=f[now][j-2];
                    }
                    if(j>1&&i>0&&(p.charAt(j-2)=='.'||p.charAt(j-2)==s.charAt(i-1))){
                        f[now][j]=f[now][j]||f[old][j];
                    }
                }
            }
        }
        
        return f[now][plen];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String a="aab";
        String b="c*a*b";
        System.out.println("result: " + obj.isMatch(a,b));
	}
}