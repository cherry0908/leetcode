import java.util.*;
import java.util.Arrays;

public class Main
{
    
	static boolean checkPerfectSquare(double x)  
    { 
    	double sq = Math.sqrt(x);
    	return ((sq - Math.floor(sq)) == 0); 
    }
    
    public void backtrack(int[] A, int position, boolean[] visited, ArrayList<Integer> current, int result, List<List<Integer>> list){
		if(position == A.length){
			ArrayList<Integer> tmp = new ArrayList<Integer>(current);
			list.add(tmp);
			return;
		}
		for(int i=0;i<A.length;i++){
		    if(visited[i] == false){
		        if(i>0 && A[i] == A[i-1] && visited[i-1] == false) {
		            continue;
		        }
		        if(position==0){
		            current.add(A[i]);
        			visited[i] = true;
        			backtrack(A, position+1, visited, current, result, list);
        			current.remove(current.size()-1);
        			visited[i] = false;
		        }
		        else if(position>0){
		            int sum = current.get(position-1) + A[i];
    		        if(checkPerfectSquare(sum)){
    		            current.add(A[i]);
            			visited[i] = true;
            			backtrack(A, position+1, visited, current, result, list);
            			current.remove(current.size()-1);
            			visited[i] = false;
    		        }
		        }
		        
		    }
		}
	}
    
    public int numSquarefulPerms(int[] A) {
		int result = 0;
        if(A == null || A.length == 0){
			return 0;
		}
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		ArrayList<Integer> current = new ArrayList<Integer>();
		boolean[] visited = new boolean[A.length];
		Arrays.sort(A);
		backtrack(A, 0, visited, current, result, list);
		return list.size();
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int nums[] = {1,1,8,1,8};
        System.out.println("List: " + m.numSquarefulPerms(nums));
	}
}
