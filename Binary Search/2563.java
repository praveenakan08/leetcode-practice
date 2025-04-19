class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // 0, 1, 4, 4, 5, 7
        // 0 -> [4, 4, 5] - 3
        // 1 -> [4, 4, 5] - 3
        // 4 -> [0, 1]  - i > j x
        // 5 -> [0, 1] - i > j x
        // 7 -> []
        long count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int low = lower - nums[i], up = upper - nums[i];
            count += (binarySearch(i + 1, nums.length - 1, nums, up + 1) - binarySearch(i + 1, nums.length - 1, nums, low));
        }

        return count;
    }

    private int binarySearch(int left, int right, int[] nums, int target) {
        int mid = 0;

        while(left <= right) {
            mid = left + (right - left) / 2;

            if(nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}