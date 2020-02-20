import java.util.*;
import java.util.Arrays;

public class Main
{
    public int openLock(String[] deadends, String target) {
        if(target==null||target.length()==0) return -1;
        HashSet<String> deadSet = new HashSet<String>(Arrays.asList(deadends));
        if(deadSet.contains(target)||deadSet.contains("0000")) return -1;
        if(target.equals("0000")) return 0;
        Queue<String> queue = new LinkedList<String>();
        queue.add("0000");
        Set<String> visited = new HashSet();
        visited.add("0000");
        int level=0;
        
        while(!queue.isEmpty()){
            level++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                String current = queue.poll();
                for(int j=0;j<4;j++){
                    char c = current.charAt(j);
                    String[] next = new String[2];
                    next[0] = current.substring(0, j) + (c-'0'+1)%10 + current.substring(j+1);
                    next[1] = current.substring(0, j) + (c-'0'+10-1)%10 + current.substring(j+1);
                    for(String n : next){
                        if(n.equals(target))return level;
                        if(!deadSet.contains(n)&&!visited.contains(n)){
                            queue.add(n);
                            visited.add(n);
                        }
                    }
                }
            }
        }
        return -1;
    }

	public static void main(String[] args) {
	    Main m = new Main();
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println("result: " + m.openLock(deadends, target));
	}
}
