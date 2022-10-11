import java.io.*; 
import java.util.*; 

public class RateLimiter {
    /*
     * @param timestamp: the current timestamp
     * @param event: the string to distinct different event
     * @param rate: the format is [integer]/[s/m/h/d]
     * @return: true or false to indicate the event is limited or not
     */

    private HashMap<String, List<Integer>> hashmap;
    // rate is count per duration
    private int duration;
    private int rate;
    
    public RateLimiter(int rate, int duration) {
        this.hashmap = new HashMap<>();
        this.duration = duration;
        this.rate = rate;
    }

    public boolean isRatelimited(String event, int timestamp) {
        if(rate == 0 || timestamp <= 0) {
            return false;
        }

        if (!hashmap.containsKey(event)) {
            hashmap.put(event, new ArrayList<>());
        }
        
        // calculate the start time of the window
        int startTime = timestamp - duration + 1;
        
        // count how many entries >= startTime;
        int count = countTimes(hashmap.get(event), startTime);
        
        
        // if count < rate, we process the request
        // return false, not rate limited
        if(count < rate) {
            hashmap.get(event).add(timestamp);
            return false;
        }
        // if count >= rate, we deny the request
        // return true, limited
        else {
            return true;
        }

    }

    // find the ceiling entry in the list
    // binary search in the list of the event
    // count the timestamps that is equal or greater to the target
    // return the count
    public int countTimes(List<Integer> list, int target) {
        int size = list.size();

        if(size == 0 || list.get(size - 1) < target) {
            return 0;
        }

        int start = 0; 
        int end = size - 1;

        // find the ceiling element
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (list.get(mid) < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        // return the count of the timestamp within the window
        return size - start;

        // e.g. [0, 1, 3, 6, 7], target = 3, start = 2
        // return size - start = 5 - 2 = 3
        // e.g. [0, 1, 4, 6, 7], target = 3, start = 2
        // return size - start = 5 - 2 = 3
        // find the count of numbers that is equal or greater than target
    }
    
    public static void main(String[] args) {
        // e.g. every 60 seconds allow 3 requests, more than 3 requests will be rejected
        RateLimiter s = new RateLimiter(3, 60);
        
        System.out.println("result: " + s.isRatelimited("device_info", 30));
        System.out.println("result: " + s.isRatelimited("device_info", 30));
        System.out.println("result: " + s.isRatelimited("device_info", 30));
        System.out.println("result: " + s.isRatelimited("device_info", 30));
        
        System.out.println("result: " + s.isRatelimited("device_info", 91));
        System.out.println("result: " + s.isRatelimited("device_info", 92));
        System.out.println("result: " + s.isRatelimited("device_info", 93));
	}
}
