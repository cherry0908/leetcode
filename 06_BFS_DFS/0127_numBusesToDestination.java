import java.util.*;

public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(routes == null || routes.length == 0) return -1;
        
        if(source == target) return 0;
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                List<Integer> list = map.getOrDefault(routes[i][j], new ArrayList<>());
                list.add(i);
                map.put(routes[i][j], list);
            }
        }
        
        int result = 0;
        HashSet<Integer> taken = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        
        while(!queue.isEmpty()) {
            result++;
            
            // BFS according to each level
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                // get the current stop
                int currStop = queue.poll();
                // get the list of buses go through this stop
                List<Integer> buses = map.get(currStop);
                
                for(int bus : buses) {
                    // if the bus is already taken, continue
                    // otherwise take the bus
                    if(!taken.contains(bus)) {
                        taken.add(bus);
                        // get the entire route of this bus
                        int[] stops = routes[bus];

                        // add the stops to the queue
                        // return if the target is in these stops
                        for(int stop : stops){
                            if(stop == target) {
                                return result;
                            }

                            queue.add(stop);
                        }
                    }
                }
            }
        }
        
        return -1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{1,2,7},{3,6,7}};

        int r = s.numBusesToDestination(a, 1, 6);
        System.out.println(r);

    }
}