// TC - O(n), SC - O(n)
class Solution {
    public int minOperations(int[] nums, int k) {
        // [5,2,5,4,5], k = 2
        // [5,5,5,4,2], k = 2
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < k) {
                return -1;
            }

            if(nums[i] > k) {   // only need to count > k elements
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        return map.size();
    }
}