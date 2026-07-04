class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack <Integer> st=new Stack<>();
        HashMap <Integer,Integer> hp=new HashMap<>();
        for(int j=nums2.length-1;j>=0;j--){
           while(!st.isEmpty() && st.peek()<=nums2[j] ){
            st.pop();
           }
           if(st.isEmpty()) hp.put(nums2[j],-1);
           else hp.put(nums2[j],st.peek());

        st.push(nums2[j]);
                   }
        for(int i=0;i<nums1.length;i++){
                nums1[i]=hp.get(nums1[i]);
        }
        return nums1;
    }
}