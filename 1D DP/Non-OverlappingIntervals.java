// TC - O(n), SC - O(1)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);

        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                count++;

                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = intervals[i - 1][1];
            }
        }

        return count;
    }
}