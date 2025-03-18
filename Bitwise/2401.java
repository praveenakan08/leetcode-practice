class Solution {
    public int longestNiceSubarray(int[] nums) {
        int count = 1, left = 0, current = 0;

        for(int right = 0; right < nums.length; right++) {
            while((current & nums[right]) != 0) {
                current ^= nums[left];
                left++;
            }

            current |= nums[right];     // clear all prev bits
            count = Math.max(count, right - left + 1);
        }


        return count;
    }
}