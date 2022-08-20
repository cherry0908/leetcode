import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[][]{};
        
        List<int[]> list = new ArrayList<>();
        
        // first, sort the array by start
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                else {
                    return a[0] - b[0];
                }
            }
        });
        
        int start = intervals[0][0];
        int end = intervals[0][1];
            
        for (int[] interval : intervals) {
            if (end >= interval[0]) {
                end = Math.max(end, interval[1]);
            }
            else {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        // don't foget the last interval
        list.add(new int[]{start, end});
        
        int size = list.size();
        int[][] result = new int[size][2];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] nums = {{1,4},{4,5}};
        int[][] r = s.merge(nums);
        for (int[] x : r) {
            System.out.println(x[0] + "," + x[1]);
        }
    }
}