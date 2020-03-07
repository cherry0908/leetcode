import java.util.*;

class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0) return 0;
        char[] str=s.toCharArray();
        int n=s.length();
        //init
        int[] f=new int[n+1];
        f[0]=1;
        //previous i digits, f[0],f[1],...f[n]
        for(int i=1;i<n+1;i++){
            f[i]=0;
            //last one digit
            if(str[i-1]!='0'){
                f[i]+=f[i-1];
            }
            //last two digits
            //s[i-2]s[i-1]
            if(i>=2 && ((str[i-2]=='1')||(str[i-2]=='2'&&str[i-1]>='0'&&str[i-1]<='6'))){
                f[i]+=f[i-2];
            }
        }
        return f[n];
    }
}


public class Main
{
	public static void main(String[] args) {
        Solution obj = new Solution();
        String s="226";
        System.out.println("result: " + obj.numDecodings(s));
	}
}