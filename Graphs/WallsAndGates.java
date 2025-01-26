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