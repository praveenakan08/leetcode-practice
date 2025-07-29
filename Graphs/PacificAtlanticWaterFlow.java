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

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // m x n
        List<List<Integer>> result = new ArrayList();
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        
        int rows = heights.length, cols = heights[0].length;
        for(int i = 0; i < cols; i++) {
            dfs(0, i, heights, pacific, Integer.MIN_VALUE);
            dfs(rows - 1, i, heights, atlantic, Integer.MIN_VALUE);
        }

        for(int i = 0; i < rows; i++) {
            dfs(i, 0, heights, pacific, Integer.MIN_VALUE);
            dfs(i, cols - 1, heights, atlantic, Integer.MIN_VALUE);
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, int[][] heights, boolean[][] visited, int prevHeight) {
        if(i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || visited[i][j] || heights[i][j] < prevHeight) {
            return;
        }

        visited[i][j] = true;
        prevHeight = heights[i][j];

        dfs(i + 1, j, heights, visited, prevHeight);
        dfs(i - 1, j, heights, visited, prevHeight);
        dfs(i, j + 1, heights, visited, prevHeight);
        dfs(i, j - 1, heights, visited, prevHeight);
    }
}
