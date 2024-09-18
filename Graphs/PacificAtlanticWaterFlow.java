// TC - O(n), SC - O(1)
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] height) {
        List<List<Integer>> result = new ArrayList();
        int rows = height.length, cols = height[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // first row and last row
        for (int i = 0; i < cols; i++) {
            dfs(0, i, height, pacific, Integer.MIN_VALUE);
            dfs(rows - 1, i, height, atlantic, Integer.MIN_VALUE);
        }

        // first and last col
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, height, pacific, Integer.MIN_VALUE);
            dfs(i, cols - 1, height, atlantic, Integer.MIN_VALUE);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    public void dfs(int i, int j, int height[][], boolean visited[][], int prevHeight) {
        if (i < 0 || j < 0 || i >= height.length || j >= height[0].length || visited[i][j]
                || height[i][j] < prevHeight) {
            return;
        }

        prevHeight = height[i][j];
        visited[i][j] = true;

        dfs(i + 1, j, height, visited, prevHeight);
        dfs(i - 1, j, height, visited, prevHeight);
        dfs(i, j + 1, height, visited, prevHeight);
        dfs(i, j - 1, height, visited, prevHeight);
    }
}