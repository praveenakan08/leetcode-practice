// TC - O(n), SC - O(1)
class Solution {
    public int jump(int[] nums) {
        int left = 0, right = 0, count = 0, farthest = 0;

        while (right < nums.length - 1) {
            farthest = 0;

            for (int i = left; i <= right; i++) {
                // find max for finding right boundary
                farthest = Math.max(farthest, i + nums[i]);
            }

            left = right + 1;
            right = farthest;
            count++;
        }

        return count;
    }
}