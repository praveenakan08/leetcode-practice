class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length]; // multiplication all elements left of current 
        int right[] = new int[nums.length]; // multiplication all elements right of current 
        
        left[0] = 1;
        right[nums.length - 1] = 1;

        // left -> [1, 1, 2, 6]
        // right -> [24, 12, 4, 1]
        for(int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1]; 
            right[nums.length - i - 1] = nums[nums.length - i] * right[nums.length - i];
        }
        
        for(int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }

        return nums;
    }
}