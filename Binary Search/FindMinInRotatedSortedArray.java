// TC - O(logn), SC - O(1)
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;

        while (left < right) {
            mid = (right - left) + left / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return nums[0];
    }
}