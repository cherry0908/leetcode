import java.util.*;
import java.util.Arrays;

public class Main
{
	public void backtrack(String digits, int start, String current, List<String> result, Map<String, String> digitMap){
	    if(start == digits.length()){
	        result.add(current);
	        return;
	    }

	    String digitString = digitMap.get(digits.substring(start, start + 1));

	    for(int i = 0; i < digitString.length(); i++){
	        backtrack(digits, start + 1, current+digitString.substring(i, i + 1), result, digitMap);
	    }
	}
	
	public List<String> letterCombinations(String digits) {
	    Map<String, String> digitMap = new HashMap<String, String>();
        digitMap.put("2", "abc");
        digitMap.put("3", "def");
        digitMap.put("4", "ghi");
        digitMap.put("5", "jkl");
        digitMap.put("6", "mno");
        digitMap.put("7", "pqrs");
        digitMap.put("8", "tuv");
        digitMap.put("9", "wxyz");

		String current = "";
		List<String> result = new ArrayList<String>();

		if(digits == null || digits.length() == 0){
		    return result;
		} 
		
	    backtrack(digits, 0, current, result, digitMap);
		return result;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    String str = "23";
        System.out.println("List: " + m.letterCombinations(str));
	}
}