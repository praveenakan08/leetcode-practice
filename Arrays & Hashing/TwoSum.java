// TC - O(n), SC - O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;

                return result;
            }

            map.put(target - nums[i], i);
        }

        return result;
    }
}
