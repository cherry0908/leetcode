
import java.util.*;

class Solution {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        int[][] f=new int[m][n];
        f[0][0]=1;
        //row: from top to botton
        for(int i=0;i<m;i++){ 
            //column: from left to right
            for(int j=0;j<n;j++){
                //[0][0]...[0][n-1] only has one path, move right
                //[0][0]...[m-1][0] only has one path, move down
                if(i==0||j==0)f[i][j]=1;
                else{
                    f[i][j]=f[i-1][j]+f[i][j-1];
                }
            }
        }
        return f[m-1][n-1];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={1, 2, 5};
        System.out.println("result: " + obj.uniquePaths(3,2));
	}
}