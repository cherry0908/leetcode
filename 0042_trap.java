import java.util.*;
import java.util.Arrays;

public class Main
{
    public int trap(int[] height) {
        if(height==null||height.length==0) return 0;
        int left=0, right=height.length-1, sum=0;
        while(left<right){
            int minH = Math.min(height[left],height[right]);
            //left is shorter
            if(height[left]==minH){
                left++;
                while(left<right && height[left]<minH){
                    sum += minH - height[left];
                    left++;
                }
            }
            //right is shorter
            else{
                right--;
                while(left<right && height[right]<minH){
                    sum+=minH - height[right];
                    right--;
                }
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
