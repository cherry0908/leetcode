import java.util.*;

class Solution {
    //Time: O(nk), Space: O(nk)
    public int minCostII(int[][] costs) {
        if(costs==null||costs.length==0) return 0;
        int n=costs.length;
        int k=costs[0].length;
        if(n==0||k==0) return 0;
        //init
        int[][] f=new int[n+1][k];
        for(int j=0;j<k;j++){
            f[0][j]=0;
        }
        
        for(int i=1;i<n+1;i++){
            //find the min value and 2nd min calue int the previous f
            //min and 2nd min in f[i-1][0]...f[i-1][k-1]
            //index of the min and 2nd min
            int a=-1, b=-1;
            for(int j=0;j<k;j++){
                //there is a new min
                if(a==-1||f[i-1][j]<f[i-1][a]){
                    b=a;//min => 2nd min
                    a=j;//new min
                }
                else if(b==-1||f[i-1][j]<f[i-1][b]){
                    b=j;//new 2nd min, min is the same
                }
            }
            //DP
            for(int j=0;j<k;j++){
                //remove an element which is not the min
                if(j!=a){
                    f[i][j]=f[i-1][a]+costs[i-1][j];
                }
                //remove an elemnet which is the min, use the 2nd min
                else{
                    f[i][j]=f[i-1][b]+costs[i-1][j];
                }
            }
        }
        
        int result=Integer.MAX_VALUE;
        for(int j=0;j<k;j++){
            result=Math.min(result,f[n][j]);
        }
        return result;
    }

    //Time: O(nk), Space: O(k)
    public int minCostIIOpt(int[][] costs) {
        if(costs==null||costs.length==0) return 0;
        int n=costs.length;
        int k=costs[0].length;
        if(n==0||k==0) return 0;
        //init
        int[][] f=new int[2][k];
        for(int j=0;j<k;j++){
            f[0][j]=0;
        }
        int old, now=0;
        
        for(int i=1;i<n+1;i++){
            //use rolling array
            old=now;
            now=1-now;
            //find the min value and 2nd min calue int the previous f
            //min and 2nd min in f[i-1][0]...f[i-1][k-1]
            //index of the min and 2nd min
            int a=-1, b=-1;
            for(int j=0;j<k;j++){
                //there is a new min
                if(a==-1||f[old][j]<f[old][a]){
                    b=a;//min => 2nd min
                    a=j;//new min
                }
                else if(b==-1||f[old][j]<f[old][b]){
                    b=j;//new 2nd min, min is the same
                }
            }
            //DP
            for(int j=0;j<k;j++){
                //remove an element which is not the min
                //if there is only one element, b==-1, use the min
                if(j!=a||b==-1){
                    f[now][j]=f[old][a]+costs[i-1][j];
                }
                //remove an elemnet which is the min, use the 2nd min
                else{
                    f[now][j]=f[old][b]+costs[i-1][j];
                }
            }
        }
        
        int result=Integer.MAX_VALUE;
        for(int j=0;j<k;j++){
            result=Math.min(result,f[now][j]);
        }
        return result;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] nums={{20,19,11,13,12,16,16,17,15,9,5,18},{3,8,15,17,19,8,18,3,11,6,7,12},{15,4,11,1,18,2,10,9,3,6,4,15}};
        //int[][] nums={{14,2,11},{11,14,5},{14,3,10},{9,12,13}};
        //int[][] nums={{8}};
        System.out.println("result: " + obj.minCostII(nums));
        System.out.println("result: " + obj.minCostIIOpt(nums));
	}
}