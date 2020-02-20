import java.util.*;
import java.util.Arrays;

public class Main
{
    public void wallsAndGates(int[][] rooms) {
        int m=rooms.length;
        if(rooms==null||m==0)return;
        int n=rooms[0].length;
        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j]==0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            for(int i=0;i<4;i++){
                int newRow = row + direction[i][0];
                int newCol = col + direction[i][1];
                if(newRow>=0&&newRow<m&&newCol>=0&&newCol<n&&rooms[newRow][newCol]==Integer.MAX_VALUE){
                    rooms[newRow][newCol] = rooms[row][col]+1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }

	public static void main(String[] args) {
	    Main m = new Main();
        int i= Integer.MAX_VALUE;
        int[][] board = {{i,-1,0,i}, {i,i,i,-1}, {i,-1,i,-1}, {0,-1,i,i}};
        m.wallsAndGates(board);
        for(int a=0;a<board.length;a++){
            for(int b=0;b<board[0].length;b++){
                System.out.println(board[a][b]);
            }
        }
	}
}
