class Solution {
    public int frogJump(int[] heights, int k) {
        return rec(heights.length - 1, heights, k);
    }

    private int rec(int index, int[] heights, int k) {
        if(index == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for(int i = index - 1; i >= index - k && i >= 0; i--) {
            int cost = rec(i, heights, k) + Math.abs(heights[index] - heights[i]);
            min = Math.min(min, cost);
        }

        return min;
    }

    // memoization
    public int frogJump(int[] heights, int k) {
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);

        return rec(heights.length - 1, heights, k, dp);
    }

    private int rec(int index, int[] heights, int k, int[] dp) {
        // 10, 5, 20, 0, 15
        //  0, 1, 2, 3, 4

        // f(15) -> min(f(0), f(20)) - 15 -> 10
        // f(0) -> min(f(20), f(5)) - 0 -> 5
        // f(20) -> min(f(5), f(10)) - 20 -> 20 
        // f(5) -> min(f(10)) - 5 -> 5
        // f(10) -> 0
        if(index == 0) {
            return 0;
        }

        if(dp[index] != -1) {
            return dp[index];
        }

        int min = Integer.MAX_VALUE;
        for(int i = index - 1; i >= index - k && i >= 0; i--) {
            min = Math.min(min, rec(i, heights, k) + Math.abs(heights[i] - heights[index]));
        }

        dp[index] = min;             
        return dp[index];
    }

    // tabulation
    public int frogJump(int[] heights, int k) {
        int[] dp = new int[heights.length];
        dp[0] = 0;

        for(int i = 1; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = i - 1; j >= i - k && j >= 0; j--) {
                min = Math.min(min, dp[j] + Math.abs(heights[j] - heights[i]));
            }

            dp[i] = min;  
        }

        return dp[heights.length - 1];
    }
}
