class Solution {
    int dirs[][]= { {0, 1}, {1, 0}, {0,-1}, {-1, 0}};
    
    public class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public void dfs(int i, int j, int[][]grid, LinkedList<Pair> queue, boolean[][]visited){
        visited[i][j] = true;
        queue.addLast(new Pair(i, j));
        for(int k = 0; k < 4; k++){
            int rowdash = i + dirs[k][0];
            int coldash = j + dirs[k][1];
            
            if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || visited[rowdash][coldash] == true || grid[rowdash][coldash] == 0){
                continue;
            }
            dfs(rowdash, coldash, grid, queue, visited);
        }
    }
    
    public int shortestBridge(int[][] grid) {
        LinkedList<Pair> queue = new LinkedList<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        
        boolean flag = false;
        
//         To add all the 1's of first island in the queue using which we could access second island
        for(int i = 0; i < grid.length && !flag ; i++){
            for(int j = 0; j < grid[0].length && !flag ; j++){
                if(grid[i][j] == 1){
                    dfs(i , j, grid, queue, visited);
                    flag = true;
                }
            }
        }
        
//         BFS
        int level = 0;
        while(queue.size() > 0){
            int size = queue.size();
            while(size-- > 0){
                Pair rem = queue.removeFirst();
                
                for(int i =0; i < 4; i++){
                    int rowdash = rem.row + dirs[i][0];
                    int coldash = rem.col + dirs[i][1];
                    
                    if(rowdash < 0 || coldash < 0 || rowdash >= grid.length || coldash >= grid[0].length || visited[rowdash][coldash] == true){
                        continue;
                    }
                    
                    if(grid[rowdash][coldash] == 1){
                        return level;
                    }
                    
                    queue.addLast(new Pair(rowdash, coldash));
                }
            }
            level++;
        }
        return -1;
    }
}