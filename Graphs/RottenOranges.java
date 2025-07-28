class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0, freshCount = 0;
        Queue<int[]> q = new LinkedList();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }

                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        while (!q.isEmpty() && freshCount > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] current = q.poll();

                for (int[] dir : dirs) {
                    int x = current[0] + dir[0];
                    int y = current[1] + dir[1];

                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length &&
                            grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.add(new int[] { x, y });
                        freshCount--;
                    }
                }
            }

            minutes++;
        }

        return freshCount > 0 ? -1 : minutes;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        // m x n grid
        int freshCount = 0, minTime = 0;

        Queue<int[]> q = new LinkedList();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    freshCount++;
                }

                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        if(freshCount == 0) {
            return 0;
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // to explore the remaining elements in q at once, then use size() and explore
        while(freshCount > 0 && !q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int[] polled = q.poll();
                int x = polled[0], y = polled[1];

                for(int[] dir: dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        q.add(new int[]{newX, newY});
                        freshCount--;
                    }
                }
            }

            minTime++;
        }

        if(freshCount != 0) {
            return -1;
        }

        return minTime;
    }
}