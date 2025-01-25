// TC - O(n^2), SC - O(1)
class Solution {
    public int countSubstrings(String s) {
        int count = 0, left = 0, right = 0;

        for(int i = 0; i < s.length(); i++) {
            left = i; right = i;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }

            left = i; right = i + 1;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}