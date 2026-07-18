
class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> index = new HashMap<>();

        int l = 0;
        int r = 0;
        int maxLength = 0;

        while (r < s.length()) {

            char ch = s.charAt(r);

            // here we just shift window so maxlength as it is
            if (index.containsKey(ch) && index.get(ch) >= l) {
               
                l = index.get(ch) + 1;
             
            } 
                index.put(ch, r);
                maxLength = Math.max(maxLength, r - l + 1);
                r++;
        }

        return maxLength;
    }
}