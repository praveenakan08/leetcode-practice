// TC - O(nlogn)
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max = 1;
        Arrays.sort(nums);

        int right = nums.length - 1;
        while (right >= 0) {
            int count = 0, left = right;
            int target = nums[right];

            while (left >= 0 && nums[left] == target) {
                count++;
                left--;
            }

            int i = 0;
            right = left;
            while (left >= 0 && i < k) {
                i += target - nums[left];
                left--;

                if (i <= k) {
                    count++;
                }
            }

            max = Math.max(max, count);
        }

        return max;
    }
}