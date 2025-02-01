// TC - O(m x n), SC - O(m x n)
class Solution {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int largestIsland(int[][] grid) {
        int max = 0, islandId = 2;

        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    int size = bfs(grid, i, j, islandId);
                    map.put(islandId, size);
                    max = Math.max(max, size);
                    islandId++;
                }
            }
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    int newSize = 1; // including current 0 as 1
                    Set<Integer> seen = new HashSet();

                    for(int dir[]: dirs) {
                        int nr = dir[0] + i, nc = dir[1] + j;

                        if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] > 1) {
                            int id = grid[nr][nc];

                            if(!seen.contains(id)) {
                                seen.add(id);
                                newSize += map.get(id); // adding the sizes of neighboring islands including 0 
                            }
                        }                     
                    }

                    max = Math.max(max, newSize);
                }
            }
        }

        return max == 0 ? grid.length * grid[0].length : max;
    }

    private int bfs(int[][] grid, int i, int j, int islandId) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{i, j});
        grid[i][j] = islandId;

        int count = 0;
        while(!q.isEmpty()) {
            int[] polled = q.poll();
            int r = polled[0], c = polled[1];
            
            count++;
            for(int[] dir: dirs) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;

                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length 
                   && grid[nr][nc] == 1){
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = islandId;
                }
            }
        }

        return count;
    }
}