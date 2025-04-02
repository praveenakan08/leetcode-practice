// TC - O(n^2), SC - O(1)
class Solution {
    public long maximumTripletValue(int[] nums) {
        // [12,6,1,2,7]
        long result = 0, max = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            } // maximize the ith value, minimize jth value because difference should be max, and then k should be max 
            // get the max i value, check for all values of k and j what is the max result

            for(int j = i + 1; j < nums.length; j++) {
                result = Math.max(result, (max - nums[i]) * nums[j]);
            }
        }

        return result;
    }
}