import java.util.*;
import java.util.Arrays;

public class Main
{
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left=0, right=str.length()-1;
        while(left<=right){
            if(str.charAt(left)!=str.charAt(right)) return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
        System.out.println("List: " + m.isPalindrome("A man, a plan, a canal: Panama"));
	}
}
