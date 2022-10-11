import java.io.*; 
import java.util.*; 

class Solution {
    public int checkSumNums(int[][] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int total = 0;
        
        for (int[] row : nums) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int n = row.length;
            
            for (int i = 0; i < n; i++) {
                max = Math.max(max, row[i]);
                min = Math.min(min, row[i]);
            }
            
            // the sum of max and min
            int sum = max + min;
            
            total = total + sum;
        }
        
        return total;
    }
    
    public int checkSumString(String s) {
        if (s == null || s.length() == 0) return 0;

        String[] rows = s.split("\\n");
        List<List<Integer>> array = new ArrayList<>();

        for (String row : rows) {
            String[] strs = row.split("\\s+");
            List<Integer> list = new ArrayList<>();

            for (String str : strs) {
                if (str.length() != 0) {
                    int num = Integer.parseInt(str);
                    list.add(num);
                }
            }
            
            array.add(list);
        }

        int total = 0;
        
        for (List<Integer> list : array) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int n = list.size();
            
            for (int i = 0; i < n; i++) {
                max = Math.max(max, list.get(i));
                min = Math.min(min, list.get(i));
            }
            
            // the difference between the max and min
            int sum = max - min;
            
            total = total + sum;
        }
        
        return total;
    }
    
    public int checkSumDivide(int[][] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int total = 0;
        
        for (int[] row : nums) {
            Arrays.sort(row);
            int n = row.length;
            int divide = 0;
            
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (row[i] != row[j] && row[i] % row[j] == 0) {
                        divide = row[i] / row[j];
                        break;
                    }
                }
            }
            
            total = total + divide;
        }
        
        return total;
    }
    
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        
        // String s = "5 7 8 9 \n 8 7 6 \n 4 5 6";
        // System.out.println("result: " + obj.checkSum(s));
        
        // int[][] nums = {{5,7,8,9}, {8,7,6}, {4,5,6}};
        // System.out.println("result: " + obj.checkSum(nums));
        
        int[][] nums = {{5,7,8,10}, {8,7,2}, {4,3,6}};
        System.out.println("result: " + obj.checkSumDivide(nums));
        
	}
}