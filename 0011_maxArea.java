import java.util.*;
import java.util.Arrays;

public class Main
{
    public int maxArea(int[] height) {
        if(height==null||height.length==0) return 0;
        int left = 0, right = height.length-1, sum = 0;
        while(left<=right){
            int current=0;
            if(height[left]>=height[right]){
                current = (right-left)*height[right];
                right--;
            }
            else{
                current = (right-left)*height[left];
                left++;
            }
            sum=sum>current?sum:current;
        }
        return sum;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("List: " + m.maxArea(height));
	}
}
