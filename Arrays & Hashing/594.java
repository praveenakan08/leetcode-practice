class Solution {
    public int findLHS(int[] nums) {
       Arrays.sort(nums);

       int left = 0, right = 1, max = 0;
       while(right < nums.length) {
            int diff = nums[right] - nums[left];

            if(diff == 1) {
                max = Math.max(max, right - left + 1);
            }

            if(diff <= 1) {
                right++;
            } else {
                left++;
            }
        }

        return max;
    }
}