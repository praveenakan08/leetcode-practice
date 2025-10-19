// TC - O(n), SC - O(1)
class Solution {
    public int jump(int[] nums) {
        int left = 0, right = 0, count = 0, farthest = 0;

        while (right < nums.length - 1) {
            farthest = 0;

            for (int i = left; i <= right; i++) {
                // find max for finding right boundary
                farthest = Math.max(farthest, i + nums[i]);
            }

            left = right + 1;
            right = farthest;
            count++;
        }

        return count;
    }
}
class Solution {
    public int jump(int[] nums) {
        int min = 0, farthest = 0, left = 0, right = 0;

        // [2,3,1,1,4]
        // [0,1,2,3,4]
        // left = 0, right = 0, farthest = 0, min = 0
        while(right < nums.length - 1) {
            farthest = 0;

            for(int i = left; i <= right; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }

            left = right + 1;
            right = farthest;

            min++;
        }

        return min;
    }
}