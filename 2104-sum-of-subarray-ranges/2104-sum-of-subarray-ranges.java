class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums)-sumSubarrayMin(nums);
    }
    private int[] findnse(int []nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
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
    private int[] findpse(int []nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
         for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
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
    private int[] findnge(int []nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
         for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
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
    private int[] findpge(int []nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
         for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
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
     private long sumSubarrayMaxs(int[] arr) {
     int n=arr.length;
     int nge[]=findnge(arr);
     int pge[]=findpge(arr);
      long sum=0;
     for(int i=0;i<n;i++){
     int left=i-pge[i];
     int right=nge[i]-i;
     long freq=1L*left*right;
        sum += freq * arr[i];
     }
     return sum;

     }
     private long sumSubarrayMin(int[] arr) {
       int n=arr.length;
     int nse[]=findnse(arr);
     int pse[]=findpse(arr);
      long sum=0;
     for(int i=0;i<n;i++){
     int left=i-pse[i];
     int right=nse[i]-i;
     long freq=1L*left*right;
        sum += freq * arr[i];
     }
     return sum;
     }
}