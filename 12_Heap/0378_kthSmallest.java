
import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return 0;
        
        // kth smallest element
        // create a max heap, with k elements in the heap
        // top is the kth smallest
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int i, j, x = 0, n = matrix.length;
        
        // 1 <= k <= n^2
        while(x < k) {
            i = x / n;
            j = x % n;
            heap.add(matrix[i][j]);
            x++;
        }
        
        while(x < n * n) {
            i = x / n;
            j = x % n;
            int max = heap.peek();
            if(matrix[i][j] < max) {
                heap.poll();
                heap.add(matrix[i][j]);
            }
            x++;
        }
        
        return heap.peek();
    }


    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                maxHeap.add(matrix[i][j]);
                
                if(maxHeap.size() > k){
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.poll();
    }

}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] nums={{1,5,9},{10,11,13},{12,13,15}};
        System.out.println("result: " + obj.kthSmallest(nums, 8));
	}
}