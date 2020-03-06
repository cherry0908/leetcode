import java.util.*;

class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        //the last step is f(i-1)*A[i] get the best result
        //either include A[i] in the previous subarray, or A[i] start with a new subarray
        //f(i)=max{f(i-1)*A[i], A[i]}
        //there are negetive nums in the array so if times negetive nubmer, min becomes max
        //we use two array to keep track of min and max
        int[] f=new int[n];
        int[] g=new int[n];
        //initialize
        f[0]=nums[0];
        g[0]=nums[0];
        int max=nums[0];
        
        for(int i=1;i<n;i++){
            //f(i)=max{f(i-1)*A[i], g(i-1)*A[i], A[i]}
            f[i]=Math.max(Math.max(f[i-1]*nums[i], g[i-1]*nums[i]), nums[i]);
            //g(i)=min{f(i-1)*A[i], g(i-1)*A[i], A[i]}
            g[i]=Math.min(Math.min(f[i-1]*nums[i], g[i-1]*nums[i]), nums[i]);
            //result is the max of the max array
            max=Math.max(max, f[i]);
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        int n=nums.length;
        //reduce the f[] and g[] array to an integer to keep track of the max and min in the past steps
        int max=nums[0], min=nums[0], result=nums[0], tmp;
        
        for(int i=1;i<n;i++){
            //if nums is negetive, swap max and min
            if(nums[i]<0){
                tmp=max;
                max=min;
                min=tmp;
            }
            max=Math.max(max*nums[i], nums[i]);
            min=Math.min(min*nums[i], nums[i]);
            result=Math.max(result, max);
        }
        
        return result;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums={2,3,-2,4};
        System.out.println("result: " + obj.maxProduct(nums));
	}
}