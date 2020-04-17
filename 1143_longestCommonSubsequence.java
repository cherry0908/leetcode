import java.util.*;
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1==null||text1.length()==0||text2==null||text2.length()==0) return 0;
        
        int n=text1.length();
        int m=text2.length();
        int[][] f=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            f[i][0]=0;
        }
        for(int j=0;j<=m;j++){
            f[0][j]=0;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                f[i][j]=Math.max(f[i-1][j],f[i][j-1]);
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    f[i][j]=Math.max(f[i][j],f[i-1][j-1]+1);
                }
            }
        }
        return f[n][m];
    }

    public int longestCommonSubsequenceOptimized(String text1, String text2) {
        if(text1==null||text1.length()==0||text2==null||text2.length()==0) return 0;
        
        int n=text1.length();
        int m=text2.length();
        int[][] f=new int[2][m+1];
        for(int i=0;i<2;i++){
            f[i][0]=0;
        }
        for(int j=0;j<=m;j++){
            f[0][j]=0;
        }
        int old, now=0;
        
        for(int i=1;i<=n;i++){
            old=now;
            now=1-now;
            for(int j=1;j<=m;j++){
                f[now][j]=Math.max(f[old][j],f[now][j-1]);
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    f[now][j]=Math.max(f[now][j],f[old][j-1]+1);
                }
            }
        }
        return f[now][m];
    }

    public int longestCommonSubsequencePrintOne(String A, String B) {
        String text1=A, text2=B;
        if(text1==null||text1.length()==0||text2==null||text2.length()==0) return 0;
        int m=text1.length();
		int n=text2.length();	
		int[][] dp=new int[m+1][n+1];
		
		for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }
		System.out.println("dp");
		for(int i=0;i<=m;i++){
		    System.out.println(Arrays.toString(dp[i]));
		}
		
		int i=m;
		int j=n; 
		int len=dp[m][n];
		char[] result=new char[len];
		int p=len-1;
		while(i>0&&j>0) 
		{
			if (text1.charAt(i-1)==text2.charAt(j-1)) {
				result[p]=A.charAt(i-1);
				i--;
				j--;
				p--;
			}else {
				if(dp[i-1][j]==dp[i][j-1]) {
					j--;
				}else if(dp[i-1][j]>dp[i][j-1]) {
					i--;
				}else if(dp[i-1][j]<dp[i][j-1]) {
					j--;
				}
			}
		}
		System.out.println("one lcs: "+new String(result));
		
		return dp[m][n];
    }

    public int longestCommonSubsequencePrintWithPi(String text1, String text2) {
        if(text1==null||text1.length()==0||text2==null||text2.length()==0) return 0;
        int m=text1.length();
		int n=text2.length();	
		int[][] dp=new int[m+1][n+1];
		int[][] pi=new int[m+1][n+1];
		
		for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                //not using A's tail
                if(dp[i][j]==dp[i-1][j]) pi[i][j]=1;
                //not using B's tail;
                else pi[i][j]=2;
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
                    if(dp[i][j]==dp[i-1][j-1]+1) pi[i][j]=3;
                }
            }
        }
		System.out.println("dp");
		for(int i=0;i<=m;i++){
		    System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println("pi");
		for(int i=0;i<=m;i++){
		    System.out.println(Arrays.toString(pi[i]));
		}
		
		int i=m;
		int j=n; 
		int len=dp[m][n];
		char[] result=new char[len];
		int p=len-1;
		while(i>0&&j>0) 
		{
			if (pi[i][j]==3){
			    result[p]=text1.charAt(i-1);
				i--;
				j--;
				p--;
			}else {
				if(pi[i][j]==1){
					i--;
				}else if(pi[i][j]==2){
					j--;
				}
			}
		}
		System.out.println("one lcs: "+new String(result));
		
		return dp[m][n];
    }

    void traceBack(int i, int j, int p, char[] lcs, List<String> result, String A, String B, int[][] dp) {
		while(i>0&&j>0) {
			if(A.charAt(i-1)==B.charAt(j-1)){
				lcs[p]=A.charAt(i-1);
				i--;
				j--;
				p--;
			}
			else{
				if(dp[i-1][j]>dp[i][j-1]){
					i--;
				}
				else if(dp[i-1][j]<dp[i][j-1]){
					j--;
				}
				else{
					traceBack(i-1,j,p,lcs,result, A,B,dp);
					traceBack(i,j-1,p,lcs,result, A,B,dp);
					return;
				}
			}
		}
		result.add(new String(lcs));
	}
    public int longestCommonSubsequencePrintAll(String A, String B) {
        if(A==null||A.length()==0||B==null||B.length()==0) return 0;
        int m=A.length();
        int n=B.length();
        int[][] f=new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0){
                    f[i][j]=0;
                    continue;
                }
                f[i][j]=Math.max(f[i-1][j],f[i][j-1]);
                if(A.charAt(i-1)==B.charAt(j-1)){
                    f[i][j]=Math.max(f[i][j],f[i-1][j-1]+1);
                }   
            }
        }
		
        int i=m;
		int j=n; 
		int len=f[m][n];
		char[] lcs=new char[len];
		int p=len-1;
		List<String> result = new ArrayList<String>();
		traceBack(m,n,p,lcs,result,A,B,f);
		System.out.println("all lcs: "+result);
		
		return f[m][n];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String a="ABCBDAB";
        String b="BDCABA";
        System.out.println("result: " + obj.longestCommonSubsequencePrintAll(a,b));
	}
}