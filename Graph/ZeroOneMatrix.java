import java.util.*;
class Solution {
    int dirs[][] = {{1, 0},
                    {-1, 0},
                    {0, 1},
                    {0, -1}};
    public class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        LinkedList<Pair> queue = new LinkedList<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.addLast(new Pair(i, j));
                }else{
                    mat[i][j] = -1;
                }
            }
        }
        
        while(queue.size() > 0){
            Pair rem = queue.removeFirst();
            
            for(int i = 0; i < dirs.length; i++){
                int rowdash = rem.x + dirs[i][0];
                int coldash = rem.y + dirs[i][1];
                
                if(rowdash >= 0 && coldash >= 0 && rowdash < mat.length && coldash < mat[0].length && mat[rowdash][coldash] < 0){
                     mat[rowdash][coldash] = mat[rem.x][rem.y] + 1;
                    queue.addLast(new Pair(rowdash , coldash));
                }
            }
        }
        return mat;
    }
}