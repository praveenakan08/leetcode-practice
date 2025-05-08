class Solution {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>( Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, 0, 0, 1});   // time, x, y, step cost

        int m = moveTime.length, n = moveTime[0].length;
        int[][] minTime = new int[m][n];

        for(int[] row: minTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minTime[0][0] = 0;

        int[][] dir = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        while(!minHeap.isEmpty()) {
            int[] current = minHeap.poll();

            int currentTime = current[0], x = current[1], y = current[2], stepCost = current[3];

            if(x == m - 1 && y == n - 1) {
                return currentTime;
            }

            for(int[] d: dir) {
                int newX = d[0] + x, newY = d[1] + y;

                if(newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int waitTime = Math.max(moveTime[newX][newY] - currentTime, 0);
                    int newTime = currentTime + stepCost + waitTime;

                    if(newTime < minTime[newX][newY]) {
                        minTime[newX][newY] = newTime;
                        int nextStepCost = (stepCost == 2) ? 1 : 2;
                        minHeap.offer(new int[]{newTime, newX, newY, nextStepCost});

                    }

                }
            }
        }
        
        return -1;
    }
}