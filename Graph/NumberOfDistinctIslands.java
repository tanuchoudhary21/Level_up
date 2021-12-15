class Solution {
//     Use StringBuilder as insertion time is O(1) istead of string which takes O(n)
    public static StringBuilder psf = new StringBuilder();
    
    public void dfs(int grid[][], int row, int col){
//         Marking the cell once visited
        grid[row][col] = 0;
//         Up direction
        if(row-1 >= 0 && grid[row-1][col]==1){
            psf.append("u");
            dfs(grid, row-1, col);
        }
//         Right Direction
        if(col+1 < grid[0].length && grid[row][col+1]==1){
            psf.append("r");
            dfs(grid, row, col+1);
        }
//         Down Direction
        if(row+1 < grid.length && grid[row+1][col]==1){
            psf.append("d");
            dfs(grid, row+1, col);
        }
//         Left Direction
        if(col-1 >= 0 && grid[row][col-1]==1){
            psf.append("l");
            dfs(grid, row, col-1);
        }
//         Backtracking
        psf.append("z");
    }
    
    public int numDistinctIslands(int[][] grid) {
//         HashSet to store all distinct island
        HashSet<String> set= new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    psf = new StringBuilder();
                    psf.append("x");
                    dfs(grid, i, j);
                    
                    set.add(psf.toString());
                }
            }
        }
        
        return set.size();
        
    }
}