// TC - O(logn), SC - O(1)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0, start = 0;

        // find the minimum element
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                // found min element i.e., start of array
                start = mid;
                break;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // search in the rest of the array starting from min to end
        // otherwise search in the LHS of array starting from 0th index to min
        left = 0;
        right = nums.length - 1;
        if (target >= nums[start] && target <= nums[right]) {
            return search(nums, start, right, target);
        } else {
            return search(nums, left, start, target);
        }
    }

    private int search(int[] nums, int left, int right, int target) {
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
