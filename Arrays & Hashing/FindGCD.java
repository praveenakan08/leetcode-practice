class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);

        // given min 2 elements in the array
        int min = nums[0], max = nums[nums.length - 1];

        if (max % min == 0) {
            return min;
        }

        while (max % min != 0) {
            int temp = min;
            min = max % min;
            max = temp;
        }

        return min;
    }
}