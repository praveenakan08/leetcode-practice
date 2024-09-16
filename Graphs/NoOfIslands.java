// TC - O(n), SC - O(1)
class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] != 1) {
                    count++;
                    dfs(visited, i, j, grid);
                }
            }
        }

        return count;
    }

    public void dfs(int[][] visited, int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1' || visited[i][j] == 1) {
            return;
        }

        visited[i][j] = 1;

        dfs(visited, i, j + 1, grid);
        dfs(visited, i + 1, j, grid);
        dfs(visited, i - 1, j, grid);
        dfs(visited, i, j - 1, grid);
    }
}