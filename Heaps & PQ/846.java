import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Count frequency of each card
        Map<Integer, Integer> map = new HashMap<>();
        for (int h : hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        // Min-heap based on card value
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for (int key : map.keySet()) {
            heap.add(new int[]{key, map.get(key)});
        }

        // Process groups
        while (!heap.isEmpty()) {
            List<int[]> spare = new ArrayList<>();
            int[] first = heap.peek(); // starting card for current group
            int start = first[0];

            for (int i = 0; i < groupSize; i++) {
                if (heap.isEmpty()) return false;

                int[] current = heap.remove();
                int val = current[0], count = current[1];

                // check if consecutive
                if (val != start + i) {
                    return false;
                }

                // use one occurrence of this card
                count--;
                if (count > 0) {
                    spare.add(new int[]{val, count});
                }
            }

            // reinsert remaining counts for used cards
            for (int[] s : spare) {
                heap.add(s);
            }
        }

        return true;
    }
}
