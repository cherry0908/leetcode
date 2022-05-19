import java.io.*; 
import java.util.*; 

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        if(nums == null || len == 0) return null;
        
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            // if i is larger than the window size, the first index in the deque == i - k
            // remove the first index in the deque
            if (deque.size() != 0 && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            
            // before add the new index to the deque
            // compare the int from the end of deque with the new int
            // delete all the int smaller than the new int
            // then add the new index
            while (deque.size() != 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            
            // the window is formed when i >= k - 1
            // if k=5, i starts from 4 to len
            // the first int in the deque is the max of current window
            if (i >= k - 1){
                list.add(nums[deque.peekFirst()]);
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s="sss";
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        System.out.println("result: " + Arrays.toString(obj.maxSlidingWindow(nums, 5)));
	}
}