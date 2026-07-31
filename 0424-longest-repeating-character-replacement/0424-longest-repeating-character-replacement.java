//it is similar to max consecutive one use use that code here to find freq of each char 
//we initially find or store unique char in set along with checking feq of it and update

class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int frq[]=new int[26];
         int maxLen = 0;
        int left = 0;
        int ans=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
           frq[ch-'A']++;
           maxLen = Math.max(maxLen,frq[ch-'A']);
           while((i-left+1)-maxLen>k){
            frq[s.charAt(left)-'A']--;
            left++;
           }
           ans = Math.max(ans,i-left+1);
        }
            return ans;

    }}
    