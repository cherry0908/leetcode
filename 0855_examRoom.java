import java.util.*;
import java.util.Arrays;

public class Main
{
	//Objects in a TreeSet are stored in a sorted and ascending order
	//operations like add, remove and search take O(Log n) time.
	TreeSet<Integer> seats = new TreeSet<Integer>();
	public int n;
	
	public Main(int N) {
	    n=N;
    }
    
    public int seat() {
        if(n==0) return 0;
        int start=0, end=0, distance=0, seat=0, x;
        if(seats.size()==0){
            seats.add(0);
            return 0;
        }//1st student sitting in the room 
        
        for(int i : seats){
            if(start==0){
                x=i-start;
                if(x>distance){
                    seat = 0;
                    distance = x;
                } 
            }
            else{
                x=(i-start+1)/2;
                if(x>distance) {
                    seat = start-1+x;
                    distance = x;
                }
            }
            start=i+1;
        }//loop through all the seats has been taken
        
        x=n-start; //reach the end of the array if end seat is not taken
        if(x>distance){
            seat=n-1;
            distance=x;
        }
        
        seats.add(seat);
        return seat;
    }
    
    public void leave(int p) {
        seats.remove(p);
    }
	
	public static void main(String[] args) {
	    Main m = new Main(10);
        System.out.println("Result: " + m.seat());
        System.out.println("Result: " + m.seat());
        System.out.println("Result: " + m.seat());
        System.out.println("Result: " + m.seat());
        m.leave(4);
        System.out.println("Result: " + m.seat());
        
	}
}
