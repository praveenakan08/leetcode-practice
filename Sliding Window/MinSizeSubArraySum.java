// TC - O(n), SC - O(1)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE, left = 0, right = 0, sum = 0;

        while(right < nums.length) {
            sum += nums[right];
            right++;

            while(sum >= target && left <= right) {
                min = Math.min(min, right - left); // right is already incremented, no need to +1
                sum -= nums[left];
                left++;
            }
        }

        // if target not found
        if(min == Integer.MAX_VALUE) {
            return 0;
        }

        return min;
    }
}
