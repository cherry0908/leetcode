import java.util.*;

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int result=0;
        int[][] f=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    f[i][j]=0;
                }
                else{
                    f[i][j]=1;
                    if(i>0&&j>0){
                        f[i][j]=Math.min(Math.min(f[i-1][j],f[i][j-1]),f[i-1][j-1])+1;
                    }
                    result=Math.max(result,f[i][j]);
                }
            }
        }
        
        return result*result;
    }
}

public class Main
{
    public static void main(String[] args) {
	    Solution obj = new Solution();
	    char[][] c = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println("Result: " + obj.maximalSquare(c));
	}
}