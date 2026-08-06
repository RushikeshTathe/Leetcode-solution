class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
       int layer=0;
        Queue<int[]> queue=new LinkedList<>();
        //create result matrix to updte distance
        int [][] result=new int[n][m];
         boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
               if(mat[i][j]==0){
                queue.offer(new int[]{i,j});
                vis[i][j]=true;
               }
            }
        }
        bfs(queue,result,mat,layer,vis);
        return result;
    }
    public void bfs(Queue<int[]> queue,int[][] result,int [][]mat,int layer, boolean[][] vis){
          int n=mat.length;
        int m=mat[0].length;
         int [] dx={0,0,1,-1};
        int [] dy={1,-1,0,0};
        
        while(!queue.isEmpty()){
            int k=queue.size();
            layer++;
            for(int i=0;i<k;i++){
            int pos[]=queue.poll();
            int x=pos[0];
            int y=pos[1];
            for(int j=0;j<4;j++){
                int nx=x+dx[j];
                int ny=y+dy[j];
                if(nx<0 ||ny<0 ||nx>=n||ny>=m) continue;
                if(vis[nx][ny]) continue; 
                     result[nx][ny]=layer;
                     vis[nx][ny] = true;
                     queue.offer(new int[]{nx,ny});
              
                }
                 }
            }
    return;
    }
}