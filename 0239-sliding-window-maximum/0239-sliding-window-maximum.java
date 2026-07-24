class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int j=0;
         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] ans = new int[n - k + 1];
        for(int i=0;i<n;i++){
            int value = nums[i];
            int index = i;
          pq.offer(new int []{value,index});
          while(!pq.isEmpty() &&  pq.peek()[1] <= i - k){
                pq.poll();
          }  
          if (i >= k - 1) {
          ans[j++] = pq.peek()[0];
        }

        }
      
        return ans;
    }
    
}