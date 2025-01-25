// TC - O(n), SC - O(n)
class Solution {
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }

        int dp[] = new int[n + 1]; // stores the optimized number of ways we can climb the indexed step
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

        // Recursion using memoization
        // if(n <= 2) {
        //     return n;
        // }

        // if(dp.containsKey(n)) {
        //     return dp.get(n);
        // }

        // dp.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        // return dp.get(n);
    }
}