class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] res=new int[nums.length];
        Stack <Integer> st=new Stack<>();
        Arrays.fill(res,-1);
        for(int j=2*nums.length-1;j>=0;j--){
          int k=j%nums.length;
        while(!st.isEmpty() && st.peek()<=nums[k]){
            st.pop();         
        }
        if(!st.isEmpty() && res[k]==-1){
            res[k]=st.peek();
        }
         st.push(nums[k]);
        }
      
        return res;
    }
}