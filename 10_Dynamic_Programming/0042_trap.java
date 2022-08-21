import java.util.*;
import java.util.Arrays;

public class Solution {
    public int trapDP(int[] height) {
        if (height == null | height.length == 0) return 0;
        
        int n = height.length;
        int sum = 0;
        
        // for the first round of scan the array
        // dp[i] means the max height on its left
        int[] dpL = new int[n];
        // for the seconde round of scan the array
        // dp[i] means the max height on its right
        int[] dpR = new int[n];
        
        // init
        dpL[0] = height[0];
        dpR[n - 1] = height[n - 1];
        
        // first round of scan
        // i = 1...n-1
        for (int i = 1; i < n; i++) {
            dpL[i] = Math.max(dpL[i - 1], height[i]);
        }
        
        // second round of scan
        // i = n-2...0
        for (int i = n - 2; i >= 0; i--) {
            dpR[i] = Math.max(dpR[i + 1], height[i]);
            
            // find the lower height between left and right
            // use the diff to calculate the water it can trap
            int min = Math.min(dpL[i], dpR[i]);
            sum = sum + (min - height[i]);
        }
        
        return sum;
    }

    public int trap(int[] height) {
        if (height == null | height.length == 0) return 0;
        
        int n = height.length;
        int sum = 0;
        
        int left = 0, right = n - 1;
        int leftMax = height[0];
        int rightMax = height[n - 1];
        
        while (left <= right) {
            // scan from the direction with smaller height
            // left height < right height
            if(height[left] < height[right]) {
                
                // find a larger left height
                // update the left max
                if (height[left] > leftMax) {
                    leftMax = height[left];
                }
                // if smaller, calculate the diff
                else {
                    sum = sum + (leftMax - height[left]);
                }
                
                left++;
            }
            // right height < left height
            else {
                
                // find a larger right height
                // update the right max
                if (height[right] > rightMax) {
                    rightMax = height[right];
                }
                // if small, calculater the diff
                else {
                    sum = sum + (rightMax - height[right]);
                }
                
                right--;
            }
        }
        
        return sum;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("List: " + m.trap(height));
	}
}
