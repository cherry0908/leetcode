import java.util.*;

class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0) return 0;
        int n=costs.length;
        //cost is 0,1,...n-1
        //f is 0, 1,...n
        int[][] f=new int[n+1][3];
        f[0][0]=0;
        f[0][1]=0;
        f[0][2]=0;
        
        //the ith house
        for(int i=1;i<n+1;i++){
            //the (i-1)th house
            for(int j=0;j<3;j++){
                //the (i-2)th house, f, should be different from the (i-1)th house
                //the cost is for (i-1)th house
                if(j==0) f[i][0]=Math.min(f[i-1][1], f[i-1][2])+costs[i-1][0];
                if(j==1) f[i][1]=Math.min(f[i-1][0], f[i-1][2])+costs[i-1][1];
                if(j==2) f[i][2]=Math.min(f[i-1][0], f[i-1][1])+costs[i-1][2];
                // for(int k=0;k<3;k++){
                //     if(j!=k){
                //         //the (i-1)th house, 
                //         f[i][j]=Math.min(f[i-1][k]+costs[i-1][j], f[i][j]);
                //     }
                // }
            }
        }
        return Math.min(Math.min(f[n][0], f[n][1]), f[n][2]);
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] nums={{17,2,17},{16,16,5},{14,3,19}};
        System.out.println("result: " + obj.minCost(nums));
	}
}