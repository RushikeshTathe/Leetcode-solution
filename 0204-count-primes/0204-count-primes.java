class Solution {
    public int countPrimes(int n) {
      
        boolean [] prime=new boolean[n];
        Arrays.fill(prime,true);
       if(n<=2) return 0;
        int cnt=n-2;
       for(int i=2;i<n;i++){
        if(prime[i]==true){
            int multi=2;
            int j=i*multi;
            while(j<n){
                if(prime[j]==true){
                    cnt--;
                }
              prime[j]=false;
              multi=multi+1;
               j=i*multi;
               
            }
        }
       }
        
        return cnt;
    }
}