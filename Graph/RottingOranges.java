class Solution {
    public class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    int dirs[][] = {{-1,0},
                    {0, 1},
                    {1, 0},
                    {0, -1}};
    public int orangesRotting(int[][] grid) {
        LinkedList<Pair> queue= new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.addLast(new Pair(i , j));
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        if(fresh == 0){
            return 0;
        }
        
        int level = -1;
        
        while(queue.size() > 0){
            int size = queue.size();
            level++;
            while(size-- > 0){
                Pair rem = queue.removeFirst();
                for(int i = 0; i < dirs.length; i++){
                    int rowdash = rem.x + dirs[i][0];
                    int coldash = rem.y + dirs[i][1];
                    
                    if(rowdash >= 0 && coldash >= 0 && rowdash < grid.length && coldash < grid[0].length && grid[rowdash][coldash] == 1){
                        queue.addLast(new Pair(rowdash, coldash));
                        grid[rowdash][coldash] = 0;
                        fresh--;
                    }
                }
            }
        }
        
        if(fresh == 0){
            return level;
        }else{
            return -1;
        }
    }
}