// TC - O(2^n), SC - O(n)
class Solution {
    public int subsetXORSum(int[] nums) {
        // same - 0, diff - 1
        // 5,1 -- 101 XOR 001 = 100
        return backtrack(0, 0, nums);
    }

    private int backtrack(int i, int currentSum, int[] nums) {
        if(i >= nums.length) {
            return currentSum;
        }

        return backtrack(i + 1, currentSum ^ nums[i], nums) + backtrack(i + 1, currentSum, nums);
    }
}