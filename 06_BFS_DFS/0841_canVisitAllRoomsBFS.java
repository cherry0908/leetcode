
import java.util.*;

public class Solution {
    
    // This is a Directed graph Traversal
    // BFS
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null) return false;
        
        // the given list is a directed graph
        // BFS needs a queue of room
        // A hashset is needed to mark if the room is visited
        
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> isVisited = new HashSet<>();
        int size = rooms.size();
        
        queue.add(0);
        
        while(!queue.isEmpty()) {
            int room = queue.poll();
            isVisited.add(room);
            
            for(int key : rooms.get(room)) {
                if(!isVisited.contains(key)) {
                    queue.add(key);
                }
            }
        }
        
        return isVisited.size() == size ? true : false;
        
    }

    public static void main(String[] args) {
	    Solution s = new Solution();
        
        // [[1,3],[3,0,1],[2],[0]]
        
	    List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(3);
        lists.add(list1);
        
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        lists.add(list2);
        
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(2);
        lists.add(list3);
        
        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(0);
        lists.add(list4);
        
        System.out.println(lists);

        boolean r = s.canVisitAllRooms(lists);
        System.out.println(r);
	}
}


