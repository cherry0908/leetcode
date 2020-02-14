import java.util.*;
import java.util.Arrays;

public class Main
{
    public boolean dfs(char[][] board, String word, int row, int col, int position, boolean[][] visited){
        if(position == word.length()){
            return true;
        }
        if(row<0 || col<0 || row>=board.length || col>=board[0].length){
            return false;
        }
        if(visited[row][col] == true){
            return false;
        }
        if(word.charAt(position)!=board[row][col]){
            return false;
        }
        visited[row][col] = true;
        boolean result = dfs(board, word, row+1, col, position+1, visited) 
                        || dfs(board, word, row-1, col, position+1, visited)
                        || dfs(board, word, row, col+1, position+1, visited)
                        || dfs(board, word, row, col-1, position+1, visited);
        visited[row][col] = false;
        return result;
    } 
    
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int i,j;
        boolean[][] visited = new boolean[row][col];
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                visited[i][j] = false;
            }
        }
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                if(dfs(board, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

	public static void main(String[] args) {
	    Main m = new Main();
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println("Result: " + m.exist(board, word));
	}
}
