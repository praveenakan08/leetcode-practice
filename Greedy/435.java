class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // [[1,2],[1,3],[2,3],[3,4]]
        int result = 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    
        for(int i = 1; i < intervals.length; i++) {

            if(intervals[i - 1][1] > intervals[i][0]) {
                result++;

                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = intervals[i-1][1];
            }
        }

        return result;
    }
}