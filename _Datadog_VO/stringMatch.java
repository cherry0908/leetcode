import java.io.*; 
import java.util.*; 

class Solution {
    public boolean stringMatch(String str, String compressed) {
        if ((str == null || str.length() == 0) && (compressed == null || compressed.length() == 0)) {
            return true;
        }

        int len_s = str.length();
        int len_c = compressed.length();

        if ((len_s == 0 && len_c != 0) || (len_s != 0 && len_c == 0)) {
            return false;
        }

        char[] char_s = str.toCharArray();
        char[] char_c = compressed.toCharArray();

        int ptr_s = 0;
        int ptr_c = 0;
        int count = 0;

        while (ptr_s < len_s && ptr_c < len_c) {
            char c_c = char_c[ptr_c];
            
            // if the character is a digit, it is compressed
            // keep moveing the ptr to right
            // calculate the count of compressed letter
            if (c_c >= '0' && c_c <= '9') {
                int digit = (int)(c_c - '0');
                count = count * 10 + digit;
                ptr_c++;
            }
            // not compressed
            // both str and compressed str should have the same letter
            else {
                System.out.println("count=" + count);
                ptr_s = ptr_s + count;
                count = 0;
                if (ptr_s >= len_s) {
                    break;
                }

                char c_s = char_s[ptr_s];
                
                if (c_c == c_s) {
                    ptr_c++;
                    ptr_s++;
                }
                else {
                    return false;
                }
            }
        }

        if (ptr_s == len_s && ptr_c == len_c) {
            return true;
        }
        else {
            return false;
        }
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution s = new Solution();
        String str = "datadog";
        String compressed = "7";
        
        System.out.println("result: " + s.stringMatch(str, compressed));
	}
}