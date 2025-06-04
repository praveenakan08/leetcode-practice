class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int i = 0; i < nums.length; i++) {
            target += nums[i];
        }

        if(target % 2 != 0) {
            return false;
        }
        target /= 2;

        boolean[][] dp = new boolean[nums.length][target + 1];
        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        } 

        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j <= target; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;

                if(nums[i] <= j) {
                    take = dp[i - 1][j - nums[i]];
                } 

                dp[i][j] = take || notTake;
            }
        }

        return dp[nums.length - 1][target];
    }
}