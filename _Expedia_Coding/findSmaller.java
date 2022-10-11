import java.io.*; 
import java.util.*; 

class Solution {
    public int[] find(int[] team1, int[] team2) {
        Arrays.sort(team1);
        Arrays.sort(team2);

        int n1 = team1.length;
        int n2 = team2.length;
        int[] res = new int[n2];
        int count = 0;
        int j = 0, i = 0;

        // [1,2,3,6]
        // [1,2,3]
        // [3,5,6]
        while (i < n1 && j < n2) {
            if (team2[j] >= team1[i]) {
                count++;
                i++;
            }
            else {
                res[j] = count;
                j++;
            }
        }

        for (; j < n2; j++) {
            res[j] = count;
        }

        return res;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution s = new Solution();
        
        // int[] team1 = {2, 3, 6, 1};
        int[] team1 = {2, 3, 1};
        int[] team2 = {3, 5, 6};
        int[] res = s.find(team1, team2);
        System.out.println("result: " + Arrays.toString(res));
	}
}