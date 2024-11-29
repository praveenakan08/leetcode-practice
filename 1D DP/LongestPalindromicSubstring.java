// TC - O(n2), SC - O(1)
class Solution {
    public String longestPalindrome(String s) {
        int resInd = 0, resLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLen) {
                    resInd = left;
                    resLen = right - left + 1;
                }

                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > resLen) {
                    resInd = left;
                    resLen = right - left + 1;
                }

                left--;
                right++;
            }

        }

        return s.substring(resInd, resInd + resLen);
    }
}