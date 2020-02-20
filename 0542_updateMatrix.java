import java.util.*;
import java.util.Arrays;

public class Main
{
    public int[][] updateMatrix(int[][] matrix) {
        int m=matrix.length;
        if(matrix==null||m==0)return null;
        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<int[]>();
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    matrix[i][j]=Integer.MAX_VALUE;
                }
                else{
                    queue.add(new int[]{i,j});
                } 
            }
        }
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int row = current[0];
            int col = current[1];
            for(int i=0;i<4;i++){
                int newRow = row + direction[i][0];
                int newCol = col + direction[i][1];
                if(newRow>=0&&newRow<m&&newCol>=0&&newCol<n&&matrix[newRow][newCol]>matrix[row][col]+1){
                    matrix[newRow][newCol] = matrix[row][col]+1;
                    queue.add(new int[]{newRow,newCol});
                }
            }
        }
        return matrix;
    }

	public static void main(String[] args) {
	    Main m = new Main();
        int i= Integer.MAX_VALUE;
        int[][] board = {{0,0,0}, {0,1,0}, {1,1,1}};
        int[][] newB = m.updateMatrix(board);
        for(int a=0;a<newB.length;a++){
            for(int b=0;b<newB[0].length;b++){
                System.out.println(newB[a][b]);
            }
        }
	}
}
