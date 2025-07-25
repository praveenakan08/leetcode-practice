// TC - O(m x n), SC - O(m x n)
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    bfs(i, j, grid, dirs);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j, char[][] grid, int[][] dirs) {
        grid[i][j] = '0';

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{i, j});

        while(!q.isEmpty()) {
            int[] polled = q.poll();
            int r = polled[0], c = polled[1];

            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j, dirs);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int i, int j, int[][] dirs) {
        grid[i][j] = '0';

        Queue<int[]> q = new LinkedList();
        q.add(new int[]{i, j});

        while(!q.isEmpty()) {
            int[] polled = q.poll();
            int r = polled[0], c = polled[1];

            for(int[] dir: dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';

                }
            }

        }        
    }
}