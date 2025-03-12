class Solution {
    public int maximumCount(int[] nums) {
        int posCount = 0, negCount = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                posCount++;
            }

            if(nums[i] < 0) {
                negCount++;
            }
        }

        return Math.max(posCount, negCount);
    }
}