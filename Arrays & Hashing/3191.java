// TC - O(n), SC - O(1)
class Solution {
    public int minOperations(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] == 0) {
                nums[i] = 1;

                if(nums[i + 1] == 1) {
                    nums[i + 1] = 0;  
                } else {
                    nums[i + 1] = 1;
                }

                if(nums[i + 2] == 1) {
                    nums[i + 2] = 0;  
                } else {
                    nums[i + 2] = 1;
                }

                count++;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 1) {
                return -1;
            }
        }
        
        return count;
    }
}