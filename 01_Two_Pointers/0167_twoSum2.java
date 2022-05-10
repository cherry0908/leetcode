import java.util.*;
public class Main
{
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        if(numbers == null | len == 0) return null;
        int ptrL = 0, ptrR = len -1;
        int[] result = new int[2];
        while (ptrL < ptrR){
            int sum = numbers[ptrL] + numbers[ptrR];
            if(sum == target){
                result[0] = ptrL + 1;
                result[1] = ptrR + 1;
                return result;
            }
            else if(sum < target){
                ptrL++;
            }
            else{
                ptrR--;
            }
        }
        return null;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {2, 7, 11, 15};
	    int[] r = m.twoSum(nums, 9);
        System.out.println(r[0] + ", " + r[1]);
	}
}