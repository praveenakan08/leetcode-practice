class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robExcept(nums, 0), robExcept(nums, 1));
    }

    private int robExcept(int[] nums, int start) {
        int dp[] = new int[nums.length];
        dp[0] = nums[start];
        dp[1] = Math.max(dp[0], nums[start + 1]);

        for (int i = 2 + start; i < nums.length; i++) {
            dp[i - start] = Math.max(dp[i - start - 1], dp[i - start - 2] + nums[i]);
        }

        return dp[nums.length - 2];
    }
}