// TC - O(n)
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int currentMax = 0, currentMin = 0;

        for(int i = 0; i < nums.length; i++) {
            currentMax += nums[i];
            max = Math.max(max, currentMax);
            if(currentMax < 0) {
                currentMax = 0;
            }

            currentMin += nums[i];
            min = Math.min(min, currentMin);
            if(currentMin > 0) {
                currentMin = 0;
            }
        }

        return Math.max(max, -min);
    }
}