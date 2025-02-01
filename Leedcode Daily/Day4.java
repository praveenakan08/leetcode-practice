class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean prev = nums[0] % 2 == 0 ? true: false;

        for(int i = 1; i < nums.length; i++) {
            if(prev) {
                if(nums[i] % 2 == 0) {
                    return false;
                }

                prev = false;
             } else if(!prev) {
                if(nums[i] % 2 != 0) {
                    return false;
                }

                prev = true;
            }
        }

        return true;
    }
}