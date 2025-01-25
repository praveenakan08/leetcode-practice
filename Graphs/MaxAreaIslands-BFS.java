// TC - O(m x n), SC - O(m x n)
class Solution {
    private int max = Integer.MIN_VALUE;

    public int maxAreaOfIsland(int[][] grid) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, bfs(i, j, grid, dirs));
                }
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }

    private int bfs(int i, int j, int[][] grid, int[][] dirs) {
        Queue<int[]> q = new LinkedList();

        grid[i][j] = 0;
        q.add(new int[]{i, j});
        int count = 0;

        while(!q.isEmpty()) {
            int[] polled = q.poll();
            int r = polled[0], c = polled[1];
            count++;

            for(int[] dir: dirs) {
                int nr = r + dir[0], nc = c + dir[1];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                }
            }
        }

        return count;
    }
}