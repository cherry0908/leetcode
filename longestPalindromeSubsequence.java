class Solution {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        char[] str=s.toCharArray();
        int n=s.length();
        if(s==null||n==0) return 0;
        if(n==1) return 1;
        
        //initialize
        int[][] f= new int[n][n];
        //length of subsequence is 1
        for(int i=0;i<n;i++){
            f[i][i]=1;
        }
        //length of subsequence is 2
        for(int i=0;i<n-1;i++){
            if(str[i]==str[i+1]) f[i][i+1]=2;
            else f[i][i+1]=1;
        }
        
        //lenght of subsequence starts with 3 to n(the entire string)
        for(int len=3;len<=n;len++){
            //start is [i]
            //end is [i+len-1]
            //i+len-1<n, so i<=n-len
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                f[i][j]=Math.max(f[i+1][j],f[i][j-1]);
                if(str[i]==str[j]){
                    f[i][j]=Math.max(f[i][j],f[i+1][j-1]+2);
                }
            }
        }
        
        return f[0][n-1];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s="bbbab";
        System.out.println("result: " + obj.longestPalindromeSubseq(s));
	}
}