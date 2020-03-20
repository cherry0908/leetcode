import java.util.*;

class Solution {
    public int minCut(String s) {
        if(s==null||s.length()==0) return 0;
        char[] ss=s.toCharArray();
        int n=s.length();
        
        boolean[][] isPalindrome=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                isPalindrome[i][j]=false;
            }
        }
        //loop through all the char in the string as a mid line
        for(int mid=0;mid<n;mid++){
            //odd length palindrome
            int i=mid;
            int j=mid;
            while(i>=0&&j<n&&ss[i]==ss[j]){
                isPalindrome[i][j]=true;
                i--;
                j++;
            }
            //even length palindrome
            i=mid;
            j=mid+1;
            while(i>=0&&j<n&&ss[i]==ss[j]){
                isPalindrome[i][j]=true;
                i--;
                j++;
            }
        }
        
        int[] f=new int[n+1];
        f[0]=0;
        //s[0...i-1]
        for(int i=1;i<n+1;i++){
            f[i]=Integer.MAX_VALUE;
            //s[j...i-1]
            //the last segment
            for(int j=0;j<i;j++){
                //if s[j...i-1] is palindrome
                if(isPalindrome[j][i-1]){
                    f[i]=Math.min(f[i],f[j]+1);
                }
            }
        }
        return f[n]-1;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s="aab";
        System.out.println("result: " + obj.minCut(s));
	}
}