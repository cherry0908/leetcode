class Solution {
    public boolean isValid(int x, int y, char[][] grid, boolean[][] visited){
        if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y] && grid[x][y] == '1'){
            return true;
        }
        return false;
    }
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        
        int m = grid.length, n = grid[0].length, cnt = 0;
        int[][] dist = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] || grid[i][j] == '0') continue;
                //start a new island
                cnt++;
                //add the starting node to the queue and mark visited
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                //scan the queue until it's empty
                while(!queue.isEmpty()){
                    //get the front node from the queue
                    int[] cur = queue.poll();
                    //get four neighbours of the current node
                    for(int k = 0; k < 4; k++){
                        int newX = cur[0] + dist[k][0];
                        int newY = cur[1] + dist[k][1];
                        //if the neighbour is in the boundry, is an island and it not visited yet
                        //add to the queue and mark visited
                        if(isValid(newX, newY, grid, visited)){
                            queue.add(new int[]{newX, newY});
                            visited[newX][newY] = true;
                        }
                    }
                }
            }
        }
        
        return cnt;
    }
}