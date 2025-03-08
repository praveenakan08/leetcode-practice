// TC - O(n), SC - O(1)
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0, right = 0, count = 0, min = Integer.MAX_VALUE, w = 0;

        while(right < blocks.length()) {
            if (blocks.charAt(right) == 'W') {
                w++;
            }

            if (right - left + 1 == k) {
                min = Math.min(min, w);

                if (blocks.charAt(left) == 'W') {
                    w--;
                }
                left++;
            }

            right++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}