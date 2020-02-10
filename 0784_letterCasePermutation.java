import java.util.*;
import java.util.Arrays;

public class Main
{
    
	public void backtrack(String s, int i, String current, List<String> result){
		if(i == s.length()){
			String tmp = new String(current);
			result.add(current);
			return;
		}
		
		char letter = s.charAt(i);
		if(Character.isDigit(letter)){
			current = current + letter;
			backtrack(s, i+1, current, result);
			current = current.substring(0, current.length()-1);
		}
		else{
			current = current + Character.toLowerCase(letter);
			backtrack(s, i+1, current, result);
			current = current.substring(0, current.length()-1);
			current = current + Character.toUpperCase(letter);
			backtrack(s, i+1, current, result);
			current = current.substring(0, current.length()-1);
		}
	}

    public void perms(int idx, StringBuilder builder, List<String> perms,  String S) {
        if (idx == S.length()) {
            perms.add(builder.toString());
            return;
        }

        char c = S.charAt(idx);
        if (Character.isDigit(c)) {
            builder.append(c);
            perms(idx + 1, builder, perms, S);
            builder.deleteCharAt(builder.length() - 1);
        }else {
            char lower = Character.toLowerCase(c);
            builder.append(lower);
            perms(idx + 1, builder, perms, S);
            builder.deleteCharAt(builder.length() - 1);

            char upper = Character.toUpperCase(c);
            builder.append(upper);
            perms(idx + 1, builder, perms, S);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
		
	public List<String> letterCasePermutation(String S) {
        List<String> result =  new ArrayList<String>();
		if(S == null || S.length() == 0){
			return result;
		}
		// String current = new String();
		// backtrack(S, 0, current, result);
        perms(0, new StringBuilder(), result, S);
		return result;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    String str = "1abv";
        System.out.println("List: " + m.letterCasePermutation(str));
	}
}
