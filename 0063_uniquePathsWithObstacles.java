import java.util.*;

class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0)return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] f=new int[m][n];
        
        //start or end is obstacle, return 0
        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1) return 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //obstacle
                if(obstacleGrid[i][j]==1){
                    f[i][j]=0;
                    continue;
                }
                //top left grid
                if(i==0&&j==0){
                    f[i][j]=1;
                    continue;
                }
                f[i][j]=0;
                //if not 0th row
                if(i>0){
                    f[i][j]+=f[i-1][j];
                }
                //if not 0th colunm
                if(j>0){
                    f[i][j]+=f[i][j-1];
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
        int[][] nums={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println("result: " + obj.uniquePathsWithObstacles(nums));
	}
}