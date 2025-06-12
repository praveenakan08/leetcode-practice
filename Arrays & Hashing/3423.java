class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length - 1; i++) {
            int diff = Math.abs(nums[i] - nums[i + 1]);
            max = Math.max(diff, max);
        }

        int diff = Math.abs(nums[0] - nums[nums.length - 1]);
        max = Math.max(diff, max);
    
        return max;
    }
}
