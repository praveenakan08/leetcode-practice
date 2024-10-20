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
}