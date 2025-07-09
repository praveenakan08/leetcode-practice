// sliding window with sub array sum
// TC - O(n), SC - O(n) 
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        // t = 0 to t = eventTime 
        // [1, 2] [2, 3] [3, 5] -- gaps - n + 1
        int n = startTime.length;
        int[] gaps = new int[n + 1];

        gaps[0] = startTime[0];
        gaps[n] = eventTime - endTime[n - 1];

        for(int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }            

        // prefix sum - find subarray with max sum
        int[] prefix = new int[n + 2];
        for(int i = 1; i < n + 2; i++) {
            prefix[i] = prefix[i - 1] + gaps[i - 1];
        }

        //          0 [1, 2], [3, 5] 5
        // gap      [1, 1, 0]
        // prefix   [0, 1, 2, 2]

        // sliding window using prefix array to get the max sum -- as the gaps consecutive will give more sum
        // consider gaps together as a window
        int max = 0;
        for(int i = k + 1; i < n + 2; i++) {
            max = Math.max(max, prefix[i] - prefix[i - (k + 1)]);
        }

        return max;
    }
}