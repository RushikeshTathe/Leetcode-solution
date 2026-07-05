class Solution {
     
       int[][][] dp;
    public int maxPathScore(int[][] grid, int k) {
         int n=grid.length;
        int m=grid[0].length;
       dp= new int[n][m][k+1];
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            Arrays.fill(dp[i][j],-2);
        }
       }
       int ans= func(0,0,0,grid,k);
       if(ans<0) return -1;
        else return ans;
    }
    public int func(int i,int j,int totalcost,int [][]grid,int k){
        int n=grid.length;
        int m=grid[0].length;
        //outof bound 
        int newcost;
         if (i >= n || j >= m) return -1000000;
       
        if(grid[i][j]==0) {newcost=totalcost+0;}
        else{newcost=totalcost+1;}

         if(newcost>k) return -1000000;

        if(i==n-1 && j==m-1){
          return grid[i][j];
        }
        if(dp[i][j][newcost]!=-2){
            return dp[i][j][newcost];
        }
        int right=func(i,j+1,newcost,grid,k);
        int down =func(i+1,j,newcost,grid,k);

        int best = Math.max(right,down);
        if(best<0) return dp[i][j][newcost]= -1000000;
         else return dp[i][j][newcost]=grid[i][j]+best;
    }
}