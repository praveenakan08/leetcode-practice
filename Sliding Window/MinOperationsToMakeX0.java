// TC - O(n), SC - O(1)
class Solution {
    public int minOperations(int[] nums, int x) {
        int left = 0, sum = 0;
        // calculating total sum
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // finding window which has total sum - x value and getting the window size 
        // to get the min opeartions
        int target = sum - x, currentSum = 0, min = Integer.MAX_VALUE;
        if(target == 0) {
            return nums.length;
        }

        for(int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
           
            while(currentSum > target && left < right) {
                currentSum -= nums[left];
                left++;
            }

            if(currentSum == target) {
                min = Math.min(min, nums.length - (right - left + 1));
            }
        }

        if(min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;
    }
}