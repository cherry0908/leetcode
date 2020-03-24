import java.util.*;

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result=new ArrayList<String>();
        if(s==null) return result; 
        int n=s.length();
        if(n==0||n==1) return result;
        char[] ss=s.toCharArray();
        for(int i=0;i<n-1;i++){
            if(ss[i]==ss[i+1]){
                if(ss[i]=='+'){
                    char[] rs=ss.clone();
                    rs[i]='-';
                    rs[i+1]='-';
                    result.add(new String(rs));
                }
            }
        }
        return result;
    }
}

public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "++++";
        System.out.println("result: " + obj.generatePossibleNextMoves(s));
	}
}