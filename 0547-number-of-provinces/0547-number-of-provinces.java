class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        boolean [] vis= new boolean[v];
        int provinces=0;
        for(int i=0;i<v;i++){
            if(!vis[i]){
                provinces++;
                dfs(i,vis,isConnected);
            }
        }
        return provinces;
    }
    private static void dfs(int i,boolean []vis, int [][] isConnected){
        vis[i]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && !vis[j]){
                dfs(j,vis,isConnected);
            }
        }
        return;
    }
}