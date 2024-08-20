class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        // 1. calculate prefix
        // ex: [1, 2, 3]    -   prefix: [1, 1, 2]
        int prefix = 1;
        for(int i = 0; i < nums.length; i++) {
            output[i] = prefix;
            prefix = prefix * nums[i];
        }
        

        // 2. calculate postfix
        // ex: [1, 2, 3]    -   postfix: [6, 3, 2]
        int postfix = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            output[i] = output[i] * postfix;
            postfix = postfix * nums[i];
        }

        return output;
    }
}
