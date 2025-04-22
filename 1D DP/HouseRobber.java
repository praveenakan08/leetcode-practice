// TC - O(n), SC - O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int dp[] = new int[nums.length];
    
        // start at first house or second house = money in those houses
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        // current dp element -> either get the max of current start 
        // or rob the 
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    // memoization
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);

        return rec(nums.length - 1, nums, dp);
    }

    private int rec(int i, int[] nums, int[] dp) {
        // [2,1,1,2]
        if(i == 0) {
            return nums[i];
        }

        if(i < 0) {
            return 0;
        }

        if(dp[i] != -1) {
            return dp[i];
        }

        int pick = nums[i] + rec(i - 2, nums, dp);
        int noPick = rec(i - 1, nums, dp);
    
        dp[i] = Math.max(pick, noPick);
        return dp[i];
    }

    // tabulation
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);

        for(int i = 2; i < nums.length; i++) {
            int pick = nums[i] + dp[i - 2];
            int noPick = dp[i - 1];
    
            dp[i] = Math.max(pick, noPick);
        }
        
        return dp[nums.length - 1];
    }
}