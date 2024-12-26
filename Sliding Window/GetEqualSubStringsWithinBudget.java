// TC - O(n), SC - O(1)
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int left = 0, right = 0, sum = 0, max = Integer.MIN_VALUE;

        while (right < s.length()) {
            sum += Math.abs(s.charAt(right) - t.charAt(right));

            while (sum > maxCost && left < right) {
                sum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            if (sum >= 0 && sum <= maxCost) {
                max = Math.max(right - left + 1, max);
            }
            right++;
        }

        if (max == Integer.MIN_VALUE) {
            return 0;
        }

        return max;
    }
}