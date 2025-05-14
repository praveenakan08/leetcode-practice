class Solution {
    // TC - O(m x n), SC - O(m x n)
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return rec(m - 1, n - 1, grid, dp);
    }

    private int rec(int i, int j, int[][] grid, int[][] dp) {
        if(i == 0 && j == 0) {
            return grid[0][0];
        }

        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
            return 1000000007;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = grid[i][j] + rec(i - 1, j, grid, dp);
        int left = grid[i][j] + rec(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        
        for(int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for(int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                int up = grid[i][j] + dp[i - 1][j];
                int left = grid[i][j] + dp[i][j - 1];
                
                dp[i][j] = Math.min(up, left);
            }
        }

        return dp[m - 1][n - 1];
    }


}