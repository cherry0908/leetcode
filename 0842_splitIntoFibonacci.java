import java.util.*;
import java.util.Arrays;

public class Main
{
    public boolean bfs(String S, int start, List<Integer> result){
        if(start==S.length() && result.size()>=3) return true;
        for(int i=start;i<S.length();i++){
            if(S.charAt(start) == '0' && i!=start) return false;
            long num = Long.parseLong(S.substring(start, i+1));
            if(num>Integer.MAX_VALUE) return false;
            int size = result.size();
            //if num < sum, keep adding one more digit from the string
            if(size>=2 && num > result.get(size-2) + result.get(size-1)) return false;
            if(size<2 || num == result.get(size-2) + result.get(size-1)){
                result.add((int)num);
                if(bfs(S, i+1, result)) return true;
                result.remove(result.size()-1);
            }
        }
        return false;
    }

    public List<Integer> splitIntoFibonacci(String S) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(S==null||S.length()==0) return result;
        bfs(S, 0, result);
        return result;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    String s = "123456579";
        System.out.println("result: " + m.splitIntoFibonacci(s));
	}
}