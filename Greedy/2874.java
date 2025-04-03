// TC - O(n), SC - O(1)
class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxDiff = 0, prefixMax = nums[0], result = 0;

        for(int k = 1; k < nums.length; k++) {
            result = Math.max(maxDiff * nums[k], result);
            prefixMax = Math.max(prefixMax, nums[k]);
            maxDiff = Math.max(maxDiff, prefixMax - nums[k]);
        }

        return result;
    }
}