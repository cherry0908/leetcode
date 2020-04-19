import java.util.*;

class Solution {
    public int minDistance(String word1, String word2) {
        if(word1==null||word2==null) return 0;
        int len1=word1.length();
        int len2=word2.length();
        int[][] f=new int[len1+1][len2+1];
        f[0][0]=0;
        
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                //word1 is an empty string, insert, insert
                if(i==0){
                    f[i][j]=j;
                    continue;
                }
                //word2 is an empty string, delete, delete
                if(j==0){
                    f[i][j]=i;
                    continue;
                }
                //f[i][j-1]: insert
                //f[i-1][j]: delete
                //f[i-1][j-1]: replace
                f[i][j]=Math.min(Math.min(f[i][j-1]+1,f[i-1][j]+1),f[i-1][j-1]+1);
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    f[i][j]=Math.min(f[i][j],f[i-1][j-1]);
                }
                
            }
        }
        
        return f[len1][len2]; 
    }

    public int minDistanceOptimized(String word1, String word2) {
        if(word1==null||word2==null) return 0;
        int len1=word1.length();
        int len2=word2.length();
        int[][] f=new int[2][len2+1];
        int old, now=0;
        
        for(int i=0;i<=len1;i++){
            old=now;
            now=1-now;
            for(int j=0;j<=len2;j++){
                //word1 is an empty string, insert, insert
                if(i==0){
                    f[now][j]=j;
                    continue;
                }
                //word2 is an empty string, delete, delete
                if(j==0){
                    f[now][j]=i;
                    continue;
                }
                //f[i][j-1]: insert
                //f[i-1][j]: delete
                //f[i-1][j-1]: replace
                f[now][j]=Math.min(Math.min(f[now][j-1]+1,f[old][j]+1),f[old][j-1]+1);
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    f[now][j]=Math.min(f[now][j],f[old][j-1]);
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