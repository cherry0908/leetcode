import java.util.*;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null||s2==null||s3==null) return false;
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if(len3!=len1+len2) return false;
        if(len1==0&&len2==0&&len3==0) return true;
        
        boolean[][] f=new boolean[len1+1][len2+1];
        f[0][0]=true;
        
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(i==0&&j==0){
                    f[i][j]=true;
                    continue;
                }
                f[i][j]=false;
                if(i>0&&f[i-1][j]&&s3.charAt(i+j-1)==s1.charAt(i-1)){
                    f[i][j]=true;
                }
                if(j>0&&f[i][j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1)){
                    f[i][j]=true;
                }
            }
        }
        
        return f[len1][len2];
    }

    public boolean isInterleaveOptimiazed(String s1, String s2, String s3) {
        if(s1==null||s2==null||s3==null) return false;
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if(len3!=len1+len2) return false;
        if(len1==0&&len2==0&&len3==0) return true;
        
        boolean[][] f=new boolean[2][len2+1];
        f[0][0]=true;
        int old, now=0;
        
        for(int i=0;i<=len1;i++){
            old=now;
            now=1-now;
            for(int j=0;j<=len2;j++){
                if(i==0&&j==0){
                    f[now][j]=true;
                    continue;
                }
                f[now][j]=false;
                if(i>0&&f[old][j]&&s3.charAt(i+j-1)==s1.charAt(i-1)){
                    f[now][j]=true;
                }
                if(j>0&&f[now][j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1)){
                    f[now][j]=true;
                }
            }
        }
        
        return f[now][len2];
    }

}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String a="aabcc";
        String b="dbbca";
        String c="aadbbcbcac";
        System.out.println("result: " + obj.isInterleave(a,b,c));
	}
}