// TC - O(n), SC - O(1)
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int exceptFirst[] = new int[nums.length - 1];
        int exceptLast[] = new int[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            exceptFirst[i - 1] = nums[i];
            exceptLast[i - 1] = nums[i - 1];
        }

        return Math.max(robExcept(exceptFirst), robExcept(exceptLast));
    }

    public int robExcept(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}