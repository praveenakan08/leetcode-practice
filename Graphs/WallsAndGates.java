// TC - O(mxn), SC - O(mxn)
public class Solution {
    // multi source BFS -- *** ADD all the treasures at once in the QUEUE
    public void islandsAndTreasure(int[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] polled = q.poll();
            int r = polled[0], c = polled[1];

            for(int[] dir: dirs) {
                int nr = r + dir[0], nc = c + dir[1];

                if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] != 2147483647) {
                    continue;
                }

                q.add(new int[]{nr, nc});
                grid[nr][nc] = grid[r][c] + 1;
            }
        }
    }
}

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // m x n grid
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    dfs(i, j, grid, 0);
                }
            }
        }
    }

    private void dfs(int i, int j, int[][] grid, int count) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] < count) {
            return;
        }

        if(grid[i][j] != 0) {
            grid[i][j] = Math.min(grid[i][j], count);
        }
        count += 1;

        dfs(i + 1, j, grid, count);
        dfs(i - 1, j, grid, count);
        dfs(i, j + 1, grid, count);
        dfs(i, j - 1, grid, count);
    }
}

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // m x n grid -- using BFS
        Queue<int[]> q = new LinkedList();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()) {
            int[] polled = q.poll();
            int x = polled[0], y = polled[1];

            for(int[] dir: dirs) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;
                
                if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length &&
                    grid[newX][newY] == Integer.MAX_VALUE) {
                    grid[newX][newY] = grid[x][y] + 1;
                    q.add(new int[]{newX, newY});
                }   
            }
        }
    }
}