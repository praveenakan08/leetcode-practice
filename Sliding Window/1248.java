class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numSubArraysWithSum(nums, k) - numSubArraysWithSum(nums, k - 1); 
    }

    private int numSubArraysWithSum(int[] nums, int goal) {
        if(goal < 0) {
            return 0;
        }

        int sum = 0, left = 0, right = 0, result = 0;
        while(right < nums.length) {
            sum += nums[right] % 2;

            while(sum > goal) {
                sum -= nums[left] % 2;
                left++;
            }

            result += (right - left + 1);
            right++;
        }

        return result;
    }
}