class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor=image[sr][sc];
        if(originalColor==color)return image;
        dfs(sr,sc,color,image,originalColor); 
      
    return image;
}

 public void dfs(int sr,int sc,int color,int[][]image ,int originalColor){
     if(sr>=image.length || sr<0 || sc<0 || sc>=image[0].length || image[sr][sc]!=originalColor){
            return;
        }
        image[sr][sc]=color;
        dfs(sr+1,sc,color,image,originalColor); 
        dfs(sr-1,sc,color,image,originalColor); 
        dfs(sr,sc-1,color,image,originalColor); 
        dfs(sr,sc+1,color,image,originalColor); 
 }
}