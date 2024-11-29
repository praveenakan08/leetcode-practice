// TC - O(n2)
class Solution {
    public int countSubstrings(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                max++;

                left--;
                right++;
            }

            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                max++;

                left--;
                right++;
            }
        }

        return max;
    }
}