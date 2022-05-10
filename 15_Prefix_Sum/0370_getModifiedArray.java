import java.util.*;
public class Main
{
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        if(length == 0 || updates == null || updates.length == 0) return arr;
        int[] prefixSum = new int[length + 1];
        int start, end, inc;
        for(int i = 0; i < updates.length; i++){
            start = updates[i][0];
            end = updates[i][1];
            inc = updates[i][2];
            prefixSum[start] = prefixSum[start] + inc;
            prefixSum[end + 1] = prefixSum[end + 1] - inc;
        }
        arr[0] = prefixSum[0];
        for(int i = 1; i < length; i++){
            arr[i] = arr[i - 1] + prefixSum[i];
        }
        return arr;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        int len = 5;
        int[] result = new int[len];
        System.out.println("result: " + Arrays.toString(m.getModifiedArray(len, updates)));
	}
}