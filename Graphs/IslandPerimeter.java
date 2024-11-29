// TC - O(m + n), SC - O(m x n)
class Solution {
    int count;

    public int islandPerimeter(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            count++;
            return;
        }

        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col - 1, visited);
        dfs(grid, row + 1, col, visited);
        dfs(grid, row, col + 1, visited);
    }
}