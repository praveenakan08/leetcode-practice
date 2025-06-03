// Given nums - return true if any subsequence sum is equal to target
// GOAL in DP -- REACH BASE CASE 
// Top Down -- from END to BASE CASE    -- tabulation 
// Bottom Up -- from BASE CASE to END   -- memoization
class Solution {

    // Top Down Recursion - TC - O(2^n), SC - O(n)
    public boolean isTargetSum(int[] nums, int target) {
        return rec(nums.length - 1, nums, target);
    }

    private boolean rec(int index, int[] nums, int target) {
        if(target == 0) {
            return true;
        }

        if(nums[0] == target) {
            return true;
        }

        boolean notTake = rec(index - 1, nums, target); 
        boolean take = false;

        if(target >= nums[index]) {
            take = rec(index - 1, nums, target - nums[index]);
        }

        return take || notTake;
    }

    // Memoization - recursion + dp[]
    public boolean isTargetSum(int[] nums, int target) {
        int[][] dp = new int[nums.length][target];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return rec(nums.length - 1, nums, target, dp);
    }

    private boolean rec(int index, int[] nums, int target, int[][] dp) {
        if(target == 0) {
            return true;
        }

        if(nums[0] == target) {
            return true;
        }

        if(dp[index][target] != -1) {
            return dp[index][target];
        }

        boolean notTake = rec(index - 1, nums, target); 
        boolean take = false;

        if(target >= nums[index]) {
            take = rec(index - 1, nums, target - nums[index]);
        }

        return dp[index][target] = take || notTake;
    }

    // Tabulation - bottom up approach - BASE CASE to target
    public boolean isTargetSum(int[] nums, int target) {
        // [1, 2, 7, 3], target = 6
        boolean[][] dp = new boolean[nums.length][target + 1];

        // initialize dp array with -1
        for(int[] row: dp) {   
            Arrays.fill(row, false);
        }
        
        // base case -- when target is zero then dp[ind][0] == true
        //    0   1   2   3   4   5
        // 0 [1, -1, -1, -1, -1, -1]
        // 1 [1, -1, -1, -1, -1, -1]
        // 2 [1, -1, -1, -1, -1, -1]
        // 3 [1, -1, -1, -1, -1, -1]
        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;  // REVISIT!!

        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j <= target; j++) {
                boolean notTake = dp[i - 1][j]; 
                boolean take = false;

                if(nums[i] <= target) {
                    take = dp[i - 1][j - nums[i]];
                }

                dp[i][j] = take || notTake;
            }
        }

        return dp[nums.length - 1][target];
    }
}