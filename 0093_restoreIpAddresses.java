import java.util.*;
import java.util.Arrays;

public class Main
{
    public void backtrack(String s, int start, List<String> current, List<String> result){
		int len = current.size();
		if(len == 4){
		    if(current.get(3).length() <= 3 && start == s.length()){
    			StringBuilder tmp = new StringBuilder();
    			for(int i = 0;i<current.size();i++){
    				tmp.append(current.get(i));
    				tmp.append('.');
    			}
    			tmp.deleteCharAt(tmp.length()-1);
    			result.add(tmp.toString());
		    }
			return;
		}
		
		for(int i=1;i<4;i++){
			if(start+i<=s.length()){
			    String num = s.substring(start,start+i);
			    if(num.length()>1 && num.substring(0,1).equals("0")) continue;
			    int numI = Integer.parseInt(num);
			    if(numI>=0 && numI<=255){
			        current.add(num);
				    backtrack(s, start+i, current, result);
				    current.remove(current.size()-1);
			    }
			}
		}
	}


	public boolean isValidIP(String str){
		if(str.length() > 3) return false;
		if(str.length() > 1 && str.substring(0,1).equals("0")) return false;
		int num = Integer.parseInt(str);
		if(num < 0 || num > 255) return false;
		return true;
	}
	
    public void backtrack1(String s, int start, List<String> current, List<String> result){
		if(current.size() == 4 && start == s.length()){
			StringBuilder tmp = new StringBuilder();
			for(int i = 0;i<current.size();i++){
				tmp.append(current.get(i));
				tmp.append('.');
			}
			tmp.deleteCharAt(tmp.length()-1);
			result.add(tmp.toString());
			return;
		}
		
		for(int i=1;i<4;i++){
			if(start+i<=s.length()){
			    String num = s.substring(start,start+i);
				if(isValidIP(num)){
					current.add(num);
				    backtrack(s, start+i, current, result);
				    current.remove(current.size()-1);
				}
			}
		}
	}

	public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
		if(s==null || s.length() < 4)return result;
		List<String> current = new ArrayList<String>();
		backtrack(s, 0, current, result);
		return result;
    }
	
    
	public static void main(String[] args) {
	    Main m = new Main();
	    String s = "010010";
        System.out.println("List: " + m.restoreIpAddresses(s));
	}
}
