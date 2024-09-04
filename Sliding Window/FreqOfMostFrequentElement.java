// TC - O()
class Solution {
    public int maxFrequency(int[] nums, int k) {
       long currSum = 0;
       int left = 0, max = 0;

       Arrays.sort(nums);

        for(int right = 0; right < nums.length; ++right) {
            currSum += nums[right];

            while((long) nums[right] * (right - left + 1) - currSum > k) {
                currSum -= nums[left];
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}