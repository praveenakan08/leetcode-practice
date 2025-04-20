class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0]; 
        }

        // 2,7,9,3,1
        // 2,7,11,11+
       int[] dp = new int[nums.length]; // store the max till that house   
       dp[0] = nums[0];
       dp[1] = Math.max(nums[1], dp[0]);

        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }      

        return dp[nums.length - 1];
    }
}