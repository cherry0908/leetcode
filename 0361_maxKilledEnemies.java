import java.util.*;

class Solution {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        if(grid==null|grid.length==0||grid[0].length==0) return 0;
        
        int m=grid.length;
        int n=grid[0].length;
        int i,j;
        
        int[][] up=new int[m][n];
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                up[i][j]=0;
                if(grid[i][j]!='W'){
                    if(grid[i][j]=='E'){
                        up[i][j]++;
                    }
                    //not fist row
                    if(i>0){
                        up[i][j]+=up[i-1][j];
                    }
                }
            }
        }
        
        int[][] down=new int[m][n];
        for(i=m-1;i>=0;i--){
            for(j=0;j<n;j++){
                down[i][j]=0;
                if(grid[i][j]!='W'){
                    if(grid[i][j]=='E'){
                        down[i][j]++;
                    }
                    //not last row
                    if(i<m-1){
                        down[i][j]+=down[i+1][j];
                    }
                }
            }
        }
        
        int[][] left=new int[m][n];
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                left[i][j]=0;
                if(grid[i][j]!='W'){
                    if(grid[i][j]=='E'){
                        left[i][j]++;
                    }
                    //not the left column
                    if(j>0){
                        left[i][j]+=left[i][j-1];
                    }
                }
            }
        }
        
        int[][] right=new int[m][n];
        for(i=0;i<m;i++){
            for(j=n-1;j>=0;j--){
                right[i][j]=0;
                if(grid[i][j]!='W'){
                    if(grid[i][j]=='E'){
                        right[i][j]++;
                    }
                    //not the right column
                    if(j<n-1){
                        right[i][j]+=right[i][j+1];
                    }
                }
            }
        }
        
        int result=0;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                //this is an empty spot can put a bomb
                if(grid[i][j]=='0'){
                    result=Math.max(result, up[i][j]+down[i][j]+left[i][j]+right[i][j]);
                }
            }
        }
        
        return result;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        char[][] nums={{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
        System.out.println("result: " + obj.maxKilledEnemies(nums));
	}
}