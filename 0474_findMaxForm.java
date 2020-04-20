import java.util.*;

class Solution {
    public int getOnes(String s){
        int ones=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') ones++;
        }
        return ones;
    }
    
    public int getZeroes(String s){
        int zeroes=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0') zeroes++;
        }
        return zeroes;
    }
    
    public int findMaxFormWithHelper(String[] strs, int m, int n) {
        if(strs==null||strs.length==0) return 0;
        int T=strs.length;
        int[][][] f=new int[T+1][m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                f[0][i][j]=0;
            }
        }
        
        for(int i=1;i<=T;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    f[i][j][k]=f[i-1][j][k];
                    int cnt0=getZeroes(strs[i-1]);
                    int cnt1=getOnes(strs[i-1]);
                    if(j>=cnt0&&k>=cnt1){
                        f[i][j][k]=Math.max(f[i][j][k],f[i-1][j-cnt0][k-cnt1]+1);
                    }
                }
            }
        }
        
        int result=0;
        for(int j=0;j<=m;j++){
            for(int k=0;k<=n;k++){
                result=Math.max(result,f[T][j][k]);
            }
        }
        return result;
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs.length==0){
            return 0;
        }
        int T=strs.length;
        int[] cnt0=new int[T];
        int[] cnt1=new int[T];
        int i,j,k;
        for(i=0;i<T;i++){
            cnt0[i]=cnt1[i]=0;
            char[] s=strs[i].toCharArray();
            for(j=0;j<s.length;j++){
                if(s[j]=='0'){
                    cnt0[i]++;
                }
                else{
                    cnt1[i]++;
                }
            }
        }
        int[][][] f=new int[T+1][m+1][n+1];
        for(i=0;i<=m;i++){
            for(j=0;j<=n;j++){
                f[0][i][j]=0;
            }
        }
        
        for(i=1;i<=T;i++){
            for(j=0;j<=m;j++){
                for(k=0;k<=n;k++){
                    f[i][j][k]=f[i-1][j][k];
                    if(j>=cnt0[i-1]&&k>=cnt1[i-1]){
                        f[i][j][k]=Math.max(f[i][j][k],f[i-1][j-cnt0[i-1]][k-cnt1[i-1]]+1);
                    }
                }
            }
        }
        
        int res=0;
        for(j=0;j<=m;j++){
            for(k=0;k<=n;k++){
                res=Math.max(res,f[T][j][k]);
            }
        }
        return res;
    }

    public int findMaxFormOptimized(String[] strs, int m, int n) {
        if(strs==null||strs.length==0) return 0;
        int T=strs.length;
        int[] cnt0=new int[T];
        int[] cnt1=new int[T];
        for(int i=0;i<T;i++){
            cnt0[i]=cnt1[i]=0;
            char[] s=strs[i].toCharArray();
            for(int j=0;j<s.length;j++){
                if(s[j]=='0'){
                    cnt0[i]++;
                }
                else{
                    cnt1[i]++;
                }
            }
        }
        
        int[][][] f=new int[2][m+1][n+1];
        int old, now=0;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                f[now][i][j]=0;
            }
        }
        
        for(int i=1;i<=T;i++){
            old=now;
            now=1-now;
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    f[now][j][k]=f[old][j][k];
                    if(j>=cnt0[i-1]&&k>=cnt1[i-1]){
                        f[now][j][k]=Math.max(f[now][j][k],f[old][j-cnt0[i-1]][k-cnt1[i-1]]+1);
                    }
                }
            }
        }
        
        int result=0;
        for(int j=0;j<=m;j++){
            for(int k=0;k<=n;k++){
                result=Math.max(result,f[now][j][k]);
            }
        }
        return result;
    }
}

public class Main
{
	public static void main(String[] args) {
	    Solution obj = new Solution();
	    String[] strs={"0","00","1"};
		System.out.println("result: " + obj.findMaxForm(strs,1,0));
	}
}
