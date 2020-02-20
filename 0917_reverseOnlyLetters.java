import java.util.*;
import java.util.Arrays;

public class Main
{
    public String reverseOnlyLetters(String S) {
        if(S==null|S.length()==0) return S;
        int left=0, right=S.length()-1;
        char[] str = S.toCharArray();
        while(left<right){
            if(!Character.isLetter(str[left])) left++;
            else if(!Character.isLetter(str[right])) right--;
            else{
                char tmp = str[left];
                str[left] = str[right];
                str[right] = tmp;
                left++;
                right--;
            }  
        }
        return new String(str);
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
        String s="Qedo1ct-eeLg=ntse-T!";
        System.out.println("List: " + m.reverseOnlyLetters(s));
	}
}
