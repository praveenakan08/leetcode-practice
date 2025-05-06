class Solution {
    // TC - O(2^mn), SC - O(n)
    public int uniquePaths(int m, int n) {
        return rec(m - 1, n - 1, m, n);
    }

    private int rec(int i, int j, int m, int n) {
        if(i == 0 && j == 0) {
            return 1;
        }

        if(i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        int left = rec(i, j - 1, m, n);
        int up = rec(i - 1, j, m, n);
        
        return left + up;
    }

    // TC - O(m*n), SC - O(m*n)
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return rec(m - 1, n - 1, m, n, dp);
    }

    private int rec(int i, int j, int m, int n, int[][] dp) {
        if(i == 0 && j == 0) {
            return 1;
        }

        if(i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int left = rec(i, j - 1, m, n, dp);
        int up = rec(i - 1, j, m, n, dp);
        dp[i][j] = left + up;

        return dp[i][j];
    }

    // tabulation TC - O(m*n), SC - O(m*n) 
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // count to reach row 1 is 1 
        for(int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // count to reach col 1 is 1 
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i > 0 && j > 0) {
                    int right = dp[i][j - 1]; 
                    int down = dp[i - 1][j];

                    dp[i][j] = right + down;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}