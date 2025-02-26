// TC - O(n)
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0, min = 0;
        int currentSum = 0, result = 0;

        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            
            result = Math.max(result, Math.abs(currentSum - max));
            result = Math.max(result, Math.abs(currentSum - min));

            min = Math.min(min, currentSum);
            max = Math.max(max, currentSum);
            
        }

        return result;
    }
}