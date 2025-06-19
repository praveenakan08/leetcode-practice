class Solution {
    public int partitionArray(int[] nums, int k) {
        // nums, k 
        Arrays.sort(nums);

        int result = 1, min = nums[0], max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);

            if(max - min > k) {
                result++;
                min = max = nums[i];
            }
        }

        return result;
    }
}