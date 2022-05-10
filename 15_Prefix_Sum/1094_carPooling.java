import java.util.*;
public class Main
{
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips == null || capacity <= 0) return false;
        int len = Integer.MIN_VALUE;
        for(int i = 0; i < trips.length; i++){
            len = Math.max(len, trips[i][2]);
        }
        len = len + 1;
        int[] prefixSum = new int[len];
        int from, to, num;
        for(int i = 0; i < trips.length; i++){
            num = trips[i][0];
            from = trips[i][1];
            to = trips[i][2];
            prefixSum[from] = prefixSum[from] + num;
            prefixSum[to] = prefixSum[to] - num;
        }
        if(prefixSum[0] > capacity){
            return false;
        }
        for(int i = 1; i < len; i++){
            prefixSum[i] = prefixSum[i - 1] + prefixSum[i];
            if(prefixSum[i] > capacity){
                return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int[][] updates = {{9,0,1},{3,3,7}};
        int cap = 4;
        System.out.println("result: " + m.carPooling(updates, cap));
	}
}