class Solution {
    public int maxScore(int[] nums, int k) {
        // find the min window in the middle
        int left = 0, right = nums.length - k - 1, sum = 0, total = 0;

        for(int i = left; i <= right; i++) {
            sum += nums[i];
        }

        int newSum = sum;
        while(right + 1 < nums.length) {
            newSum -= nums[left];
            left++;

            right++;
            newSum += nums[right];

            if(newSum < sum) {
                sum = newSum;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        return total - sum;
    }
}