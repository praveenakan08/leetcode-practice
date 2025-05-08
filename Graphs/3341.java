// TC - O(mn), SC - O(mn)
// shortest path from start to end using weighted graph

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        // MINIMUM TIME -- BFS or Dijkstra's min path
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));  // {time, x, y}
        int m = moveTime.length, n = moveTime[0].length;
        int[][] minTime = new int[m][n];

        for(int[] row: minTime) {
            Arrays.fill(row, Integer.MAX_VALUE);    // fill the 2D matrix with infinity -- it will have min time to reach that (x, y) from (0, 0)
        }

        minHeap.offer(new int[]{0, 0, 0});

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!minHeap.isEmpty()) {
            int[] current = minHeap.poll();

            int currentTime = current[0], x = current[1], y = current[2];
            if(x == m - 1 && y == n - 1) {
                return currentTime;
            }

            for(int[] d: dir) {
                int newX = x + d[0], newY = y + d[1];

                if(newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int waitTime = Math.max(moveTime[newX][newY] - currentTime, 0); // if currentTime = 1 and adj is 4 then waitTime is 4 - 1 = 3, that is we need to wait 3 units to reach the next step
                    int newTime = currentTime + 1 + waitTime;

                    if(newTime < minTime[newX][newY]) {
                        minTime[newX][newY] = newTime;
                        minHeap.offer(new int[]{newTime, newX, newY});
                    }
                }
            }
        }

        return -1;
    }
}
