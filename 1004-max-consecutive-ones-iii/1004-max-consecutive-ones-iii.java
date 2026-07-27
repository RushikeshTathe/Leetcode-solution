class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        int right = 0;
        int left = 0;

        while (right < n) {

            if (nums[right] == 0 && k > 0) {
                k--;
                right++;
            }
            else if (nums[right] == 0 && k == 0) {

                while (nums[left] != 0) {
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