class Solution {

    // recursion
    public int minFallingPathSum(int[][] matrix) {
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < matrix[0].length; i++) {
            result = Math.min(result, rec(matrix.length - 1, i, matrix));
        }
        
        return result;
    }

    // [[2,1,3],[6,5,4],[7,8,9]] 
    private int rec(int i, int j, int[][] matrix) {
        if(j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }

        if(i == 0) {
            return matrix[0][j];
        }

        int left = matrix[i - 1][j - 1] + rec(i - 1, j - 1, matrix); 
        int right = matrix[i - 1][j + 1] + rec(i - 1, j + 1, matrix); 
        int up = matrix[i - 1][j] + rec(i - 1, j, matrix); 
        
        return Math.min(Math.min(left, right), up);
    }

    // memoization -- bottom up approach
    public int minFallingPathSum(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        int m = matrix.length, n = matrix[0].length;

        int[][] dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int i = 0; i < matrix[0].length; i++) {
            result = Math.min(result, rec(matrix.length - 1, i, matrix, dp));
        }
        
        return result;
    }

    // [[2,1,3],[6,5,4],[7,8,9]] 
    private int rec(int i, int j, int[][] matrix, int[][] dp) {
        if(j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }

        if(i == 0) {
            return matrix[0][j];
        }

        if(dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int left = rec(i - 1, j - 1, matrix, dp); 
        int right = rec(i - 1, j + 1, matrix, dp); 
        int up = rec(i - 1, j, matrix, dp); 
        
        return dp[i][j] = matrix[i][j] + Math.min(Math.min(left, right), up);
    }

    public int minFallingPathSum(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        int m = matrix.length, n = matrix[0].length;

        int[][] dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int up = dp[i - 1][j];

                int left = Integer.MAX_VALUE;
                if(j > 0) {
                    left = dp[i - 1][j - 1];
                }

                int right = Integer.MAX_VALUE;
                if(j + 1 < n) {
                    right = dp[i - 1][j + 1];
                }

                int min = matrix[i][j] + Math.min(Math.min(left, right), up);
                dp[i][j] = Math.min(min, dp[i][j]);
            }
        }

        for(int i = 0; i < n; i++) {
            result = Math.min(result, dp[m - 1][i]);
        }
        
        return result;
    }
}