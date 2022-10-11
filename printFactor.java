import java.util.*;

public class Solution {
    public void factor(int n) {
        if (n == 0) return;
        
        List<Integer> list = new ArrayList<Integer>();
        
        int factor = 2;
        int num = n;
        
        while (num != 1) {
            if (num % factor == 0) {
                num = num / factor;
                list.add(factor);
            }
            else {
                factor++;
            }
        }
        
        System.out.print("1");
        
        for (int x : list) {
            System.out.print("*" + x);
        }
        
        System.out.println("");

        return;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.factor(12);
	}
}