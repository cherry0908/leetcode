import java.util.*;
import java.util.Arrays;

public class Main
{
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
		if(n==0)return result;
        int[] columnVal = new int[n];
        dfs(n,0,columnVal,result);
        return result;
    }
    
    public void dfs(int nQueens, int row, int[] columnVal, List<List<String>> result){
        if(row == nQueens){
            ArrayList<String> current = new ArrayList<String>();
            for(int i = 0; i < nQueens; i++){
                StringBuilder s = new StringBuilder();
                for(int j = 0; j < nQueens; j++){
                    if(j == columnVal[i])
                        s.append("Q");
                    else
                        s.append(".");
                }
                current.add(s.toString());
            }
            result.add(current);
        }else{
            for(int i = 0; i < nQueens; i++){ //for each row
                columnVal[row] = i;//(row,columnVal[row]), where the queen is
                if(isValid(row,columnVal)){
                    dfs(nQueens, row+1, columnVal, result);
                }
            }
        }
    }
    
    public boolean isValid(int row, int [] columnVal){
        for(int i = 0; i < row; i++){
            if(columnVal[row] == columnVal[i]||Math.abs(columnVal[row]-columnVal[i]) == row-i)
               return false;
        }
        return true;
    }

	public static void main(String[] args) {
	    Main m = new Main();
        System.out.println("List: " + m.solveNQueens(4));
	}
}
