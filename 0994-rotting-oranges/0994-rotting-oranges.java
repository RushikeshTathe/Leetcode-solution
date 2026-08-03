//here we think about bfs and each level give min 
//first we create queue to store rotten oranges each time we try rotten adj of that queues oranges 
// 
class Solution {
    public int orangesRotting(int[][] grid) {
          if (grid.length == 0) return 0;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
             for( int j=0;j<m;j++){
                if(grid[i][j]==2){
                   rottenTime(grid,i,j,2);
                }
             }
        }
        int minutes=2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                 if (grid[i][j] == 1) {
            return -1;
        }
        minutes = Math.max(minutes, grid[i][j]);
         }
    }
 return minutes-2;
}
        private void rottenTime(int [][] grid,int i,int j,int minutes){
            int n=grid.length;
        int m=grid[0].length;
            if(i<0 || j<0|| j>=m || i>=n || grid[i][j]==0||(grid[i][j]>1 && grid[i][j]<minutes)) return;
            else{
                grid[i][j]=minutes;
                rottenTime(grid,i+1,j,minutes+1);
                rottenTime(grid,i,j+1,minutes+1);
                rottenTime(grid,i-1,j,minutes+1);
                rottenTime(grid,i,j-1,minutes+1);
            }
        }
    
}