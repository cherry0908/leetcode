import java.util.*;
import java.util.Arrays;

public class Main
{
    public int findContentChildren(int[] g, int[] s) {
        if(g==null||g.length==0||s==null||s.length==0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int total=0, gp=0, sp=0;
        while(gp<g.length && sp<s.length){
            if(s[sp]>=g[gp]){
                total++;
                sp++;
                gp++;
            }
            else{
                sp++;
            }
        }
        return total;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println("List: " + m.findContentChildren(g,s));
	}
}
