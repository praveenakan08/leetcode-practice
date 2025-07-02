class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // pair -> {index, dist}
        Queue<int[]> minHeap = new PriorityQueue<>(new Comparator<>() {
            public int compare(int[] p1, int[] p2) {
                return p1[1] - p2[1];
            }
        });

         for(int i = 0; i < points.length; i++) {
            int dist = (int)Math.pow(points[i][0], 2) + (int)Math.pow(points[i][1], 2);
            minHeap.add(new int[]{i, dist});
        }
        int[][] result = new int[k][2];
        int i = 0;

        while(i != k) {
            int[] polled = minHeap.poll();
            result[i][0] = points[polled[0]][0];
            result[i][1] = points[polled[0]][1];
            
            i++;
        }

        return result;
    }
}