import java.io.*; 
import java.util.*;

class Solution {
    int[] prefixSum;

    public Solution(int[] w) {
        int len = w.length;
        prefixSum = new int[len];
        prefixSum[0] = w[0];
        for(int i = 1; i < len; i ++){
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        int len = prefixSum.length;
        Random rand = new Random();
        int randInt = rand.nextInt(prefixSum[len - 1]);
        // find the first number larger than randInt in the prefixSum array
        // binary search
        int start = 0, end = len - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(randInt >= prefixSum[mid]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return end;
    }
}

public class Main
{
	public static void main(String[] args) {
        int[] w = {1,3};
        Solution obj = new Solution(w);
        int param_1 = obj.pickIndex();
        System.out.println("result: " + param_1);
        param_1 = obj.pickIndex();
        System.out.println("result: " + param_1);
        param_1 = obj.pickIndex();
        System.out.println("result: " + param_1);
        param_1 = obj.pickIndex();
        System.out.println("result: " + param_1);
        param_1 = obj.pickIndex();
        System.out.println("result: " + param_1);
	}
}

