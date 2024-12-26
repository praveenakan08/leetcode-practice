// TC - O(n), SC - O(n)
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int max = Integer.MIN_VALUE, right = 0, left = 0;

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }

        return max;
    }
}