import java.util.*;
import java.util.Arrays;

public class Main
{
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A==null||B==null) return null;
        List<int[]> result = new ArrayList<int[]>();
        int pa=0,pb=0;
        while(pa<A.length&&pb<B.length){
            int maxStart = Math.max(A[pa][0], B[pb][0]);
            int minEnd = Math.min(A[pa][1], B[pb][1]);
            if(maxStart<=minEnd) result.add(new int[]{maxStart, minEnd});
            if(A[pa][1]>B[pb][1]) pb++;
            else pa++;
        }
        int len = result.size();
        int[][] r = new int[len][2];
        for(int i=0;i<len;i++){
            r[i] = result.get(i);
        }
        return r;
    }

	public static void main(String[] args) {
	    Main m = new Main();
        
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
        int[][] board = m.intervalIntersection(A, B);
        for(int a=0;a<board.length;a++){
            for(int b=0;b<board[0].length;b++){
                System.out.println(board[a][b]);
            }
        }
	}
}
