import java.util.*;
public class Main
{
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers==null||numbers.length<2) return result;
        int start=0,end=numbers.length-1;
        while(start<end){
            if(numbers[start]+numbers[end]==target){
                result[0]=start+1;
                result[1]=end+1;
                return result;
            }
            else if(numbers[start]+numbers[end]>target){
                end--;
            }
            else{
                start++;
            }
        }
        return result;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {2,7,11,15};
	    int[] r = m.twoSum(nums,9);
        System.out.println(r[0] + ", " + r[1]);
	}
}