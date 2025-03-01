// TC - O(n), SC - O(1)
class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }

        int index = 0;
        // fill the first positions with non zero elements
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        // fill remaining positions with 0
        while(index < nums.length) {
            nums[index++] = 0; 
        }
        return nums;
    }
}