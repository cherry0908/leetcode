import java.io.*; 
import java.util.*; 

class Solution {
    public String longestPalindrome(String s) {
        if(s==null||s.length()<=1) return s;
        int n=s.length();
        char[] str=s.toCharArray();
        boolean[][] f=new boolean[n][n];
        int start=0, len=1;
        //init
        for(int i=0;i<n;i++){
            f[i][i]=true;
        }
        for(int i=0;i<n-1;i++){
            if(str[i]==str[i+1]){
                f[i][i+1]=true;
                if(len<2){
                    start=i;
                    len=2;
                }
            } 
            else f[i][i+1]=false;
        }
        for(int l=3;l<=n;l++){
            for(int i=0;i<=n-l;i++){
                int j=i+l-1;
                f[i][j]=false;
                if(str[i]==str[j]&&f[i+1][j-1]==true){
                    f[i][j]=true;
                    if(l>len){
                        start=i;
                        len=l;
                    }
                }
            }
        }
        
        return s.substring(start,start+len);
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s="sss";
        //System.out.println(s.substring(3,3+1));
        System.out.println("result: " + obj.longestPalindrome(s));
	}
}