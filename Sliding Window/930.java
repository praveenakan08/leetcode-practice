// TC - O(n), SC - O(1)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubArraysWithSum(nums, goal) - numSubArraysWithSum(nums, goal - 1); 
    }

    private int numSubArraysWithSum(int[] nums, int goal) {
        if(goal < 0) {
            return 0;
        }

        int sum = 0, left = 0, right = 0, result = 0;
        while(right < nums.length) {
            sum += nums[right];

            while(sum > goal) {
                sum -= nums[left];
                left++;
            }

            result += (right - left + 1);
            right++;
        }

        return result;
    }
}