import java.util.*;
import java.util.Arrays;

public class Main
{
	public void backtrack(int n, int left, int right, String current, List<String> result){
		if(right == n){
			String tmp = new String(current);
			result.add(tmp);
			return;
		}
		
		if(left < n){
			backtrack(n, left+1, right, current+"(", result);
		}
		if(right < left){
			backtrack(n, left, right+1, current+")", result);
		}	
	}

	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
		String current = new String();
		if(n==0)return result;
		backtrack(n, 0, 0, current, result);
		return result;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int n=3;
        System.out.println("List: " + m.generateParenthesis(n));
	}
}
