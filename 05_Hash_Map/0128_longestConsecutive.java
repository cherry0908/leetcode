import java.util.*;
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        int max = 1;
        
        for(int num : nums) {
            set.add(num);
        }
        
        for(int num : nums) {
            if(set.contains(num)) {
                set.remove(num);
                int current = 1;
                
                int next = num + 1;
                while(set.contains(next)) {
                    set.remove(next);
                    current++;
                    next++;
                }
                
                int prev = num - 1;
                while(set.contains(prev)) {
                    set.remove(prev);
                    current++;
                    prev--;
                }
                
                max = Math.max(max, current);
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
	    int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println("result: " + s.longestConsecutive(nums));
	}
}