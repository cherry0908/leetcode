import java.util.*;

public class Solution{
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int na = a.length() - 1;
        int nb = b.length() - 1;
        int n = Math.max(na, nb);
        char[] total = new char[n + 1];
        int carry = 0;
        
        while (n >= 0) {
            int sum = 0;
            if (na >= 0) {
                sum += charA[na] - '0';
            }
            if (nb >= 0) {
                sum += charB[nb] - '0';
            }
            sum += carry;
            total[n] = (char) (sum % 2 + '0');
            carry = sum / 2;
            na--;
            nb--;
            n--;
        }
        
        String result = "";
        if (carry == 1) {
            result = result + "1";
        }
        
        result = result + new String(total);
        
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String r = s.addBinary("10111", "11");
        System.out.println(r);
    }
}