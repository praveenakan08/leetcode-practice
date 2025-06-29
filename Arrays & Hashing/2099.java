class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // [2, 1, 3, 3]
        //  0, 1, 2, 3
        // sorted -- [(3, 3), (3, 2), (2, 0), (1, 1)]
        //           [(3, 2), (3, 3)....] sort k values
        int[][] values = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            values[i] = new int[]{nums[i], i};
        }

        // sort by desc order values
        Arrays.sort(values, (a, b) -> b[0] - a[0]);

        // sort by asc order indices
        Arrays.sort(values, 0, k, (a, b) -> a[1] - b[1]);

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = values[i][0];
        }


        return result;
    }
}