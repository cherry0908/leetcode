/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    
    /*
    //basic BFS, Total runtime 1733 ms
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if(grid == null || grid.length == 0) return -1;
        int m = grid.length, n = grid[0].length, steps = 0;
        if(source.x < 0 || source.x >= m || source.y < 0 || source.y >= n || grid[source.x][source.y] || grid[destination.x][destination.y]) return -1;
        
        int[][] dist = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        boolean[][] visited = new boolean[m][n];
        Queue<Point> queue = new LinkedList<Point>();
        
        queue.add(source);
        visited[source.x][source.y] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point cur = queue.poll();
                if(cur.x == destination.x && cur.y == destination.y) {
                    return steps;
                }
                
                for(int j = 0; j < 8; j++){
                    int newX = cur.x + dist[j][0];
                    int newY = cur.y + dist[j][1];
                    if(newX < 0 || newX >= m || newY < 0 ||newY >= n || grid[newX][newY] || visited[newX][newY]) continue;
                    Point next = new Point(newX, newY);
                    queue.add(next);
                    visited[newX][newY] = true;
                }
            }
            steps++;
        }
        
        return -1;
    }
    */
    
    public boolean isValid(int x, int y, boolean[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y]) {
            return false;
        }
        return true;
    }
    
    /*
    //use hashmap to store distance between the source and current point
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int n = grid.length, m = grid[0].length;
        if(source.x < 0 || source.x >= m || source.y < 0 || source.y >= n || grid[source.x][source.y] || grid[destination.x][destination.y]) return -1;
        
        int[][] dist = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        Queue<Point> queue = new LinkedList<Point>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        queue.add(source);
        map.put(source.x * m + source.y, 0);

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if(cur.x == destination.x && cur.y == destination.y) {
                return map.get(cur.x * m + cur.y);
            }
            for (int i = 0; i < 8; i++) {
                int newX = cur.x + dist[i][0];
                int newY = cur.y + dist[i][1];
                if (!isValid(newX, newY, grid)) {
                    continue;
                }
                if (map.containsKey(newX * m + newY)) {
                    continue;
                }
                queue.add(new Point(newX, newY));
                map.put(newX * m + newY, map.get(cur.x * m + cur.y) + 1);
            }
        }
        
        return -1;
    }
    */
    
    //bi-directional BFS
    public int shortestPath(boolean[][] grid, Point source, Point destination){
        
    }
    
}