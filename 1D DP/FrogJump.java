// https://www.geeksforgeeks.org/problems/geek-jump/1
// whenever min/max problems - try greedy way 
// that is, to take min/max in every step 
// but in this case, it will not work because while taking min in the current step, we might miss out 
// on the overall min cost, so try all - that is recursion
// Recursion steps:
// 1. convert this into index recurrence relation f(n) -- this is recursion so main problem to base case 
// 2. do all possible operations from current index -- in this case, do the recursion from 1 and 2 steps behind  
// 3. return min/max of all the operations based on the problem 
    // 10 30 40 20 50
    // f(n) -> min cost to reach from 0 to n
    // f(50) -> min(f(20) + 30, f(40) + 10) - 40
    // f(20) -> min(f(40) + 20, f(30) + 10) - 30
    // f(40) -> min(f(30) + 10), f(10) + 30) - 30
    // f(30) -> min(f(10) + 20, INF) - 20
    // f(10) -> 0 (min cost to reach from 0 -> 0)
class Solution {
    // sol 1
    public int minCost(int[] heights) {
        return rec(heights.length - 1, heights);
    }

    private int rec(int i, int[] heights) {
        if(i == 0) {
            return 0;
        }

        int oneStep = rec(i - 1, heights) + Math.abs(heights[i - 1] - heights[i]);
        int twoStep = Integer.MAX_VALUE;
        if(i > 1) {
            twoStep = rec(i - 2, heights) + Math.abs(heights[i - 2] - heights[i]);
        }

        return Math.min(oneStep, twoStep);
    }

    public int minCost(int[] heights) {
        int[] dp = new int[heights.length];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        
        return rec(heights.length - 1, heights, dp);
    }

    // DP - 1 Memoization - main case to base case - using recursion
    private int rec(int i, int[] heights, int[] dp) {
        if(i == 0) {
            return 0;
        }
        
        if(dp[i] != -1) {
            return dp[i];
        }

        int oneStep = rec(i - 1, heights, dp) + Math.abs(heights[i - 1] - heights[i]);
        int twoStep = Integer.MAX_VALUE;
        if(i > 1) {
            twoStep = rec(i - 2, heights, dp) + Math.abs(heights[i - 2] - heights[i]);
        }

        dp[i] = Math.min(oneStep, twoStep);
        return dp[i];
    }

    // DP - 2 tabulation 
    public int minCost(int[] heights) {
        int[] dp = new int[heights.length];
        dp[0] = 0; // cost of jumping from 0 to 0
    
        // look at the memoization sol -> replace rec() with dp 
        for(int i = 1; i < heights.length; i++) {
            int oneStep = dp[i - 1] + Math.abs(heights[i - 1] - heights[i]);
            int twoStep = Integer.MAX_VALUE;
            if(i > 1) {
                twoStep = dp[i - 2] + Math.abs(heights[i - 2] - heights[i]);
            }
            
            dp[i] = Math.min(oneStep, twoStep);
            
        }
        return dp[heights.length - 1];
    }

    // DP - 3 There will ALWAYS be a space optimized sol if indices are i - 1 and i - 2
    public int minCost(int[] heights) {
        int prev = 0, prev2 = 0, current = 0;
        // dp[i - 1] -> prev
        // dp[i - 2] -> prev2
       
        for(int i = 1; i < heights.length; i++) {
            int oneStep = prev + Math.abs(heights[i - 1] - heights[i]);
            int twoStep = Integer.MAX_VALUE;
            if(i > 1) {
                twoStep = prev2 + Math.abs(heights[i - 2] - heights[i]);
            }
            
            current = Math.min(twoStep, oneStep);
            prev2 = prev;
            prev = current;
        }
        return current;
    }

}
