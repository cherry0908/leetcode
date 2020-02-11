import java.util.*;
import java.util.Arrays;

public class Main
{
	public boolean isValidSudoku(char[][] board){
        HashMap<Character, Integer>[] row = new HashMap[9];
        HashMap<Character, Integer>[] col = new HashMap[9];
        HashMap<Character, Integer>[] box = new HashMap[9];
        for(int i=0;i<9;i++){
            row[i]= new HashMap<Character, Integer>();
            col[i]= new HashMap<Character, Integer>();
            box[i]= new HashMap<Character, Integer>();
        }
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num = board[i][j];
                if(num != '.'){
                    int k = (i/3)*3+j/3;
                    if(row[i].containsKey(num) || col[j].containsKey(num) || box[k].containsKey(num)){
                        return false;
                    }
                    row[i].put(num,1);
                    col[j].put(num,1);
                    box[k].put(num,1);
                }
            }
        }
        return true;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','7','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
        };
        System.out.println("result: " + m.isValidSudoku(board));
	}
}
