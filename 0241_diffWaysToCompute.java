import java.util.*;
import java.util.Arrays;

public class Main
{
    public HashMap<String, List<Integer>> memo = new HashMap<String, List<Integer>>();
    public List<Integer> diffWaysToCompute(String input) {
        if(memo.containsKey(input)) return memo.get(input);
        List<Integer> result = new ArrayList<Integer>();
        if(input==null||input.length()==0)return result;
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
                for(int l:left){
                    for(int r:right){
                        if(c=='+') {
                            result.add(l+r);
                        }
                        else if(c=='-'){
                            result.add(l-r);
                        }
                        else if(c=='*'){
                            result.add(l*r);
                        }
                    }
                }
            }
        }
        if(result.size()==0){
            result.add(Integer.valueOf(input));
        }
        memo.put(input, result);
        return result;
    }
	
    
	public static void main(String[] args) {
	    Main m = new Main();
	    String s = "2*3-4*5";
        System.out.println("List: " + m.diffWaysToCompute(s));
	}
}
