import java.util.*;

public class Main
{
	Map<String, String> digitMap = new HashMap<String, String>();
    List<String> resultList = new ArrayList<String>();

	public void helper(String digits, int position, String result){
	    if(position == digits.length()){
	        resultList.add(result);
	    }
	    else{
	        String digitString = digitMap.get(digits.substring(position, position+1));
	        for(int i=0;i<digitString.length();i++){
	            helper(digits, position+1, result + digitString.substring(i, i+1));
	        }
	    }
	}
	
	public void helper2(String restOfDigits, String result){
	    if(restOfDigits.length() == 0){
	        resultList.add(result);
	    }
	    else{
	        String digitString = digitMap.get(restOfDigits.substring(0,1));
	        for(int i=0;i<digitString.length();i++){
	            helper2(restOfDigits.substring(1), result+digitString.substring(i, i+1));
	        }
	    }
	}
  
    public List<String> letterCombinations(String digits) {
        digitMap.put("2", "abc");
        digitMap.put("3", "def");
        digitMap.put("4", "ghi");
        digitMap.put("5", "jkl");
        digitMap.put("6", "mno");
        digitMap.put("7", "pqrs");
        digitMap.put("8", "tuv");
        digitMap.put("9", "wxyz");
		String result = "";
		if(digits.length() != 0){
	        helper2(digits, result);
	        //helper(digits, 0, result);
	    }
		return resultList;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    String str = "23";
        System.out.println("List: " + m.letterCombinations(str));
	}
}