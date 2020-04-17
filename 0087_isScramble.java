class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1==null||s2==null||s1.length()!=s2.length()) return false;
        int n=s1.length();
        if(n==0) return true;
        //init
        boolean[][][] f=new boolean[n][n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //length=0
                f[i][j][0]=true;
                //length=1
                if(s1.charAt(i)==s2.charAt(j)) f[i][j][1]=true;
                else f[i][j][1]=false;
            }
        }
        
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                for(int j=0;j<=n-len;j++){
                    //where to split the sctring
                    //1<=k<=len-1
                    for(int k=1;k<=len-1;k++){
                        //no swap
                        if(f[i][j][k]&&f[i+k][j+k][len-k]){
                            f[i][j][len]=true;
                            break;
                        }
                        //swap
                        if(f[i][j+len-k][k]&&f[i+k][j][len-k]){
                            f[i][j][len]=true;
                            break;
                        }
                    }
                }
            }
        }
        return f[0][0][n];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s1="great";
        String s2="rgeat";
        System.out.println("result: " + obj.isScramble(s1,s2));
	}
}