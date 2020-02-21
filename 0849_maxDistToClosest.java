import java.util.*;
import java.util.Arrays;

public class Main
{
	public int maxDistToClosest(int[] seats) {
        if(seats==null||seats.length==0) return 0;
        int start=0, end=0, distance=0, seat=0, x;
        while(end<seats.length){
            if(seats[end]==1){
                if(start==0){
                    x=end-start;
                    if(x>distance){
                        seat = 0;
                        distance = x;
                    } 
                    //distance=Math.max(distance, x);
                }
                else{
                    x=(end-start+1)/2;
                    if(x>distance) {
                        seat = start-1+x;
                        distance = x;
                    }
                    //distance=Math.max(distance, (end-start+1)/2);
                }
                start=end+1;
            }
            end++;
        }
        x=end-start;
        if(x>distance){
            seat=end;
            distance=x;
        } 
        //distance=Math.max(distance, x);
        return distance;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {1,0,0,0};
        System.out.println("Result: " + m.maxDistToClosest(nums));
	}
}
