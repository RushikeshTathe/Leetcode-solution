class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxArea=0;

        int pse[]=findpse(heights);
            int nse[]=findnse(heights);

        for(int i=0;i<n;i++){
           int range=nse[i]-pse[i]-1;
            int minheight=heights[i];
               int area=range*minheight;
                maxArea=Math.max(area,maxArea);        
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