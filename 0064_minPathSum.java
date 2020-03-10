import java.util.*;

class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int m=grid.length;
        int n=grid[0].length;
        //init
        int[][] f=new int[m][n];
        f[0][0]=grid[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //top left corner
                if(i==0&&j==0) continue;
                f[i][j]=Integer.MAX_VALUE;
                //if it has grid above, aka not the top row
                if(i>0){
                    f[i][j]=Math.min(f[i-1][j]+grid[i][j], f[i][j]);
                }
                //if it has grid on the left, aka not the left column
                if(j>0){
                    f[i][j]=Math.min(f[i][j-1]+grid[i][j], f[i][j]);
                }
            }
        }
        return f[m-1][n-1];
        
    }

    public int minPathSum1(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int m=grid.length;
        int n=grid[0].length;
        //init
        int[][] f=new int[m][n];
        f[0][0]=grid[0][0];
        //left column
        for(int i=1;i<m;i++){
            f[i][0]=f[i-1][0]+grid[i][0];
        }
        //top row
        for(int j=1;j<n;j++){
            f[0][j]=f[0][j-1]+grid[0][j];
        }
        //teh rest grid
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                f[i][j]=Math.min(f[i-1][j], f[i][j-1])+grid[i][j];
            }
        }
        return f[m-1][n-1];
    }

    public int minPathSum2(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int m=grid.length;
        int n=grid[0].length;
        //init
        //rolling array, only need 2 rows to hold the result
        //f[old][...] is holding f[i-1][...]
        //f[current][...] is holding f[i][...]
        int[][] f=new int[2][n];
        
        int old, current=0;
        for(int i=0;i<m;i++){
            //swap old and current
            old=current;
            current=1-current;
            for(int j=0;j<n;j++){
                //top left corner
                if(i==0&&j==0){
                    f[current][j]=grid[i][j];
                    continue;
                } 
                f[current][j]=Integer.MAX_VALUE;
                //if it has grid above, aka not the top row
                if(i>0){
                    f[current][j]=Math.min(f[old][j]+grid[i][j], f[current][j]);
                }
                //if it has grid on the left, aka not the left column
                if(j>0){
                    f[current][j]=Math.min(f[current][j-1]+grid[i][j], f[current][j]);
                }
            }
        }
        return f[current][n-1];
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] nums={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("result: " + obj.minPathSum1(nums));
	}
}