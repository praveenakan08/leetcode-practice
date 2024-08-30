class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladder) {
        int count = 0;
        // using max heap - store the differences in heights, always use bricks first,
        // if bricks turn negative, then pop an element from max heap and use ladder,
        // add the difference back to the bricks
        PriorityQueue<Integer> q = new PriorityQueue(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] < heights[i + 1]) {
                int diff = heights[i + 1] - heights[i];
                bricks -= diff;
                q.add(diff);

                if (bricks < 0) {
                    if (ladder == 0) {
                        return i;
                    }

                    // use ladder
                    if (!q.isEmpty()) {
                        ladder--;

                        // add the diff to bricks
                        bricks += q.poll();
                    }
                }
            }
        }

        return heights.length - 1;
    }
}