//it is similar to max consecutive one use use that code here to find freq of each char 
//we initially find or store unique char in set along with checking feq of it and update
class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int longest=1;
        HashSet <Character> set=new HashSet<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!set.contains(ch)){
               int Substringlen= findfreq(ch,k,s);
                longest=Math.max(longest,Substringlen);
                set.add(ch);
            }
        }
            return longest;

    }
    private int findfreq(char ch ,int k,String s){
        int n=s.length();
         int maxLen = 0;
        int right = 0;
        int left = 0;

        while (right < n) {

            if (s.charAt(right) != ch && k > 0) {
                k--;
                right++;
            }
            else if (s.charAt(right) != ch && k == 0) {

                while (s.charAt(left) == ch) {
                    left++;
                }
                k++;
                left++; // remove one zero from the window
            }
            else {
                right++;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}