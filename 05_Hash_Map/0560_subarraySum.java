import java.util.*;
public class Main
{
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        if(nums == null || len == 0) return 0;
        int[] prefixSum = new int[len + 1];
        int count = 0;
        prefixSum[0] = 0;
        // calculate prefix sum
        for(int i = 1; i < len + 1; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1]; 
        }
        
        // calculate the sum of each subarray
        // beware i starts with 0 and j starts following i
        // i=0 means the entire subarray starts from nums[0]
        for(int i = 0; i < len; i ++){
            for(int j = i + 1; j < len + 1; j++){
                // the sum of nums[i] to nums[j]
                if(prefixSum[j] - prefixSum[i] == k){
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        if(nums == null || len == 0) return 0;
        // the hashmap is a prefix sum map
        // key is the prefix sum, value is the number of times the prefix exist in the array
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0, sum = 0;
        map.put(0, 1);
        // starts with num[0], calculate the current sum of num[0]...num[i]
        for(int i = 0; i < len; i++){
            sum = sum + nums[i];
            // sum - prefixSum[x] needs to equal to k
            // the diff is to check whether it exist in the prefix sum hashmap
            int diff = sum - k;
            if(map.containsKey(diff)){
                count = count + map.get(diff);
            }
            // put the current prefix sum in the map
            // if exist, value + 1
            if(map.containsKey(sum)){
                map.replace(sum, map.get(sum) + 1);
            }
            else{
                map.put(sum, 1);
            }
        }
        return count;
    }

	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {1, 2, 3};
        System.out.println("result: " + m.subarraySum(nums, 3));
	}
}