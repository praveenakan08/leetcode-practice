// max sub array with sliding window
class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        // 1. create an array for gaps 
        // 2. prefix sum array using gaps 
        // 3. using sliding window in the prefix array get the max gap time
        int n = startTime.length, max = 0;
        int[] gaps = new int[n + 1];

        // start and end gaps 
        gaps[0] = startTime[0]; 
        gaps[n] = eventTime - endTime[n - 1];

        for(int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }

        // gaps --   [1, 1, 0]
        // prefix -- [0, 1, 2, 2]
        int[] prefix = new int[n + 2];
        prefix[0] = 0;
        for(int i = 1; i < n + 2; i++) {
            prefix[i] = prefix[i - 1] + gaps[i - 1];
        }

        for(int i = 1; i < prefix.length; i++) {
            max = Math.max(max, prefix[i] - prefix[i - 1]);
        }

        // TODO complete this solution

        return max;
    }
}