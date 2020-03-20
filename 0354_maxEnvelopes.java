import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // for(int[] pair : envelopes){
        //     System.out.println(Arrays.toString(pair));
        // }
        // System.out.println();
        
        //sort the array based on envelopes[i][0]
        Arrays.sort(envelopes, new Comparator<int[]>() { 
            @Override              
            // Compare values according to columns 
            public int compare(int[] array1, int[] array2) { 
                // To sort in ascending order  
                //if array1[0]>array2[0], exchange
                if(array1[0]>array2[0]) return 1; 
                //if array1[0]<array2[0], remain
                else if(array1[0]<array2[0]) return -1;
                //if array1[0]==array2[0], the order depends on array1[1] and array2[1]
                else{
                    if(array1[1]>array2[1]) return 1;
                    else return -1;
                }
            } 
        });
        
        for(int[] pair : envelopes){
            System.out.println(Arrays.toString(pair));
        }
        
        //longest increasing subsequence based on envolopes[i][1]
        int n=envelopes.length;
        int[] f=new int[n];
        f[0]=1;
        int result=0;
        for(int i=1;i<n;i++){
            f[i]=1;
            for(int j=0;j<i;j++){
                if(j<i&&envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1]){
                    f[i]=Math.max(f[i],f[j]+1);
                }
            }
            result=Math.max(result, f[i]);
        }
        return result;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] nums={{4,5},{4,6},{6,7},{2,3},{1,1}};
        System.out.println("result: " + obj.maxEnvelopes(nums));
	}
}