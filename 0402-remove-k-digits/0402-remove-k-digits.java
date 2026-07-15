class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int i=0;
        while (i < num.length()) {

            while (!st.isEmpty() && k > 0 && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
            i++;
        }
        // Remove remaining digits from the end
         while (k > 0) {
            st.pop();
            k--;
        }
         StringBuilder result = new StringBuilder();
     while (!st.isEmpty()) {
            result.append(st.pop());
        }
        result.reverse();

          while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
         // If nothing remains
        if (result.length() == 0) {
            return "0";
        }
         return result.toString();
    }
}