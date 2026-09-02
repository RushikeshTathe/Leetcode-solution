class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
          return solve(nums,k)-solve(nums,k-1); 
    }
    public int solve(int [] nums,int k){
        int n=nums.length;
        int cnt=0;
        int right=0;
        int left=0;
         HashMap <Integer,Integer> map = new HashMap<>();
            while(right<n && left<=right){
                map.put(nums[right],map.getOrDefault(nums[right],0)+1);
                
                while(map.size()>k){  
                    map.put(nums[left],map.get(nums[left])-1);
                    if(map.get(nums[left])==0) map.remove(nums[left]);
                    left++;
                }
                cnt+=right-left+1;
                right++;
            }
        
        return cnt;
    }
}