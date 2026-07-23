class Solution {
    public int maximalRectangle(char[][] matrix) {
         int n=matrix.length;
         int m=matrix[0].length;
         int height[]=new int[m];
          int maxArea=0;
        for(int j=0;j<n;j++){
          for(int i=0;i<m;i++){
            if(matrix[j][i]=='0')
                height[i]=0;
             else
                 height[i]++;
         }
              int pse[]=findpse(height);
            int nse[]=findnse(height);

         for(int i=0;i<m;i++){
           int range=nse[i]-pse[i]-1;
            int minheight=height[i];
               int area=range*minheight;
                maxArea=Math.max(area,maxArea);        
            }

        }
     return maxArea;
    }
    private static int[] findpse(int arr[]){
        Stack <Integer> st=new Stack<>();
        int n=arr.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if (!st.isEmpty()) {
            ans[i] = st.peek();
            }
            else {
             ans[i] = -1;
            }
            st.push(i);
        }
        return ans;
    }
    private  static int[] findnse(int arr[]){
        Stack <Integer> st=new Stack<>();
        int n=arr.length;
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if (!st.isEmpty()) {
            ans[i] = st.peek();
            }
            else {
             ans[i] = n;
            }
            st.push(i);
        }
        return ans;
    }
}