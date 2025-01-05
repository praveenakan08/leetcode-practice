// TC - O(n), SC - O(1)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // circular array -- normal max or total - min
        int max = nums[0], min = nums[0], currentMaxSum = 0, currentMinSum = 0, total = 0;

        for (int i = 0; i < nums.length; i++) {
            currentMaxSum = Math.max(currentMaxSum + nums[i], nums[i]);
            currentMinSum = Math.min(currentMinSum + nums[i], nums[i]);

            max = Math.max(max, currentMaxSum);
            min = Math.min(min, currentMinSum);
            total += nums[i];
        }

        // if all elements < 0, then return total max instead of total - min which is 0
        if (max < 0) {
            return max;
        }

        return Math.max(max, total - min);
    }
}