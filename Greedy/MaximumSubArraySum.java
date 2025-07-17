// TC - O(n), SC - O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = 0;
            }

            currentSum += nums[i];
            max = Math.max(currentSum, max);
        }

        return max;
    }
}

// kadane's algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0, maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            
            if(currentSum < 0) {
                currentSum = 0;
            }

            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}