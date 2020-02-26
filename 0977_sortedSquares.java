import java.util.*;
public class Main
{
    public int[] sortedSquares(int[] A) {
        if(A==null||A.length==0) return A;
        int[] tmp = new int[A.length];
        int start=0, end=A.length-1, index=A.length-1;
        while(start<end){
            int a=A[start]*A[start];
            int b=A[end]*A[end];
            if(a > b){
                tmp[index] = a;
                start++;
                index--;
            }
            else{
                tmp[index] = b;
                end--;
                index--;
            }
        }
        if(index==0) tmp[index]=A[start]*A[start];
        return tmp;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {-7,-3,2,3,11};
        System.out.println("result: " + Arrays.toString(m.sortedSquares(nums)));
	}
}