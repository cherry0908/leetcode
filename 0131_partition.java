import java.util.*;
import java.util.Arrays;

public class Main
{
    public boolean isPalindrome(String s){
        int left= 0, right=s.length()-1;
        while(left<=right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void backtrack(String s, int start, List<String> current, List<List<String>> result){
        if(start == s.length()){
            ArrayList<String> tmp = new ArrayList<String>(current);
            result.add(tmp);
            return; 
        }
        for(int i=start;i<s.length();i++){
            String str = s.substring(start, i+1);
            if(isPalindrome(str)){
                current.add(str);
                backtrack(s, i+1, current, result);
                current.remove(current.size()-1);
            }
        }
    }

    public boolean isPalindrome1(String s, int left, int right){
        while(left<=right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void backtrack1(String s, int start, List<String> current, List<List<String>> result){
        if(start == s.length()){
            ArrayList<String> tmp = new ArrayList<String>(current);
            result.add(tmp);
            return; 
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s, start, i)){
                current.add(s.substring(start, i+1));
                backtrack(s, i+1, current, result);
                current.remove(current.size()-1);
            }
        }
    }

	public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s==null||s.length()==0) return result;
        List<String> current = new ArrayList<String>();
        backtrack(s,0, current, result);
        return result;
    }
	
    
	public static void main(String[] args) {
	    Main m = new Main();
	    String s = "aab";
	    //System.out.println("string: " + s.substring(0,s.length()));
        System.out.println("List: " + m.partition(s));
	}
}
