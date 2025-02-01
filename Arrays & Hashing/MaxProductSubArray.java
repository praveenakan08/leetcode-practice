// TC - O(n), SC - O(1)
class Solution {
    public int maxProduct(int[] nums) {
        int left = 1, right = 1, max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(left == 0) {
                left = 1;
            }
            if(right == 0) {
                right = 1;
            }

            left *= nums[i];
            right *= nums[nums.length - i - 1];

            max = Math.max(left, Math.max(right, max));
        }

        return max;
    }
}