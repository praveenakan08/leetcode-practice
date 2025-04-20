class Solution {
    // tabulation
    // public int climbStairs(int n) {
    //     if(n == 1) {
    //         return 1;
    //     }

    //     int dp[] = new int[n + 1];
    //     dp[1] = 1;
    //     dp[2] = 2;

    //     // 4 -> [0, 1, 2, 3, ]
    //     // 4 -> 
    //     // 2 -> 2
    //     // 3 -> 1 + 1 + 1
    //         //  2 + 1
    //         //  1 + 2
    //         // 3
    //     for(int i = 3; i <= n; i++) {
    //         dp[i] = dp[i - 1] + dp[i - 2];
    //     }

    //     return dp[dp.length - 1];
    // }

    // memoization
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        // [-1, -1, -1, -1];
        return rec(n, dp);
    }

    private int rec(int n, int[] dp) {
        if(n == 1) {
            return 1;
        }

        if(n == 2) {
            return 2;
        }

        if(dp[n] != -1) {
            return dp[n];
        }

        dp[n] = rec(n - 1, dp) + rec(n - 2, dp);
        return dp[n];
    }
}