import java.util.*;
import java.util.Arrays;

public class Main
{
    public boolean isLongPressedName(String name, String typed) {
        if(name==null||name.length()==0||typed==null||typed.length()==0) return false;
        int p1=0, p2=0;
        while(p1<name.length()){
            if(p2==typed.length()) return false;
            if(name.charAt(p1) == typed.charAt(p2)){
                p1++;
                p2++;
            }
            else if(name.charAt(p1) != typed.charAt(p2)){
                if(p2==0) return false;
                if(p2>0 && typed.charAt(p2) == typed.charAt(p2-1)) {
                    p2++;
                }
                else return false;
            }
        }
        if(p2==typed.length()) return true;
        while(p2<typed.length()){
            if(typed.charAt(p2)!=typed.charAt(p2-1)) return false;
            p2++;
        }
        return true;
    }
    
	public static void main(String[] args) {
	    Main m = new Main();
        String name="saeed";
        String typed="ssaaedd";
        System.out.println("List: " + m.isLongPressedName(name,typed));
	}
}
