class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return rec(m - 1, n - 1, grid, m, n);
    }

    private int rec(int i, int j, int[][] grid, int m, int n) {
        if(i == 0 && j == 0) {
            return 1;
        }

        if(i >= 0 && j >= 0 && grid[i][j] == -1) {
            return 0;
        }

        if(i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        int left = rec(i, j - 1, grid, m, n);
        int up = rec(i - 1, j, grid, m, n);
        
        return left + up;
    }
}