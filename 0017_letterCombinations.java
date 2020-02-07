import java.util.*;

public class Main
{
	Map<String, String> digitMap = new HashMap<String, String>();
    List<String> resultList = new ArrayList<String>();

	public void helper(String digits, int position, String result){
	    String digitString = digitMap.get(digits.substring(position, position+1));
	    for(int i=0;i<digitString.length();i++){
	        String addLetter = result + digitString.substring(i, i+1);
	        if(position == digits.length()-1){
	            resultList.add(addLetter);
	        }
    	    else{
    	        helper(digits, position+1, addLetter);
    	    }
	    }
	}
	
	public void helper2(String restOfDigits, String result){
	    if(restOfDigits.length() == 0){
	        resultList.add(result);
	    }
	    else{
	        String digit = restOfDigits;
	        String digitString = digitMap.get(digit);
	        for(int i=0;i<digitString.length();i++){
	            String letter = digitString.substring(i, i+1);
	            helper2(restOfDigits.substring(1), result+letter);
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
	        helper(digits, 0, result);
	    }
		return resultList;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    String str = "23";
        System.out.println("List: " + m.letterCombinations(str));
	}
}