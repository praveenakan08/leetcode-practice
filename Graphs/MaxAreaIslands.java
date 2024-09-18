// TC - O(n), SC - O(1)
class Solution {
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[][] visited = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && visited[i][j] != 1) {
                    count = 0;
                    dfs(i, j, grid, visited);
                    max = Math.max(count, max);
                }
            }
        }
        
        return max;
    }

    public void dfs(int i, int j, int grid[][], int visited[][]) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == 1 || grid[i][j] == 0) {
            return;
        } 


        count++;
        visited[i][j] = 1;
        dfs(i+1, j, grid, visited);
        dfs(i-1, j, grid, visited);
        dfs(i, j+1, grid, visited);
        dfs(i, j-1, grid, visited);
    }
}