import java.util.*;
public class Main
{
    
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        int i,a;
        int[] indices = new int[2];
        for(i=0;i<nums.length;i++){
            map.put(target-nums[i],i);
        }
        for(i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                a=map.get(nums[i]);
                if(a!=i){
                    indices[0]=a;
                    indices[1]=i;
                    break;
                }
            }
        }
        return indices;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        int i,a;
        int[] indices = new int[2];
        for(i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                a=map.get(nums[i]);
                indices[0]=a;
                indices[1]=i;
                break;
            }
            else{
                map.put(target-nums[i],i);
            }
        }
        return indices;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
	    int[] nums = {3,2,4};
	    int[] nums2 = {2,7,11,15};
	    int[] r = m.twoSum2(nums,6);
        System.out.println(r[0] + ", " + r[1]);
        r = m.twoSum2(nums2,9);
        System.out.println(r[0] + ", " + r[1]);
	}
}