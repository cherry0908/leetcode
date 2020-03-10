import java.util.*;

class Solution {
    /**
     * @param num: a non negative integer number
     * @return: an array represent the number of 1's in their binary
     */
    public int[] countBits(int num) {
        int[] f=new int[num+1];
        f[0]=0;
        for(int i=1;i<=num;i++){
            f[i]=f[i>>1]+(i%2);
        }
        return f;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println("result: " + Arrays.toString(obj.countBits(5)));
	}
}