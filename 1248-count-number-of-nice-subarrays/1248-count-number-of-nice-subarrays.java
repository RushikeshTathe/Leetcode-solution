class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       
       return mostAt(nums,k)-mostAt(nums,k-1);
    }
    private int mostAt(int []nums , int k){
         int nice=0;
        int l=0;
        int  r=0;
        while(r<nums.length){
         if(nums[r]%2!=0) k--;

        while(k<0){
            if(nums[l]%2!=0) k++;
            l++;
        }
        nice+=r-l+1;
        r++;
       }
       return nice;
    }
}