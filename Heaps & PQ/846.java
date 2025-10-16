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
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }

        Queue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        for(int key: map.keySet()) {
            heap.add(new int[]{key, map.get(key)});
        }

        // 1,2,3,6,2,3,4,7,8
        // 2,3,4,6,7,8
        // [1, 2, 3], [2, 3, 4]
        while(!heap.isEmpty()) {
            List<int[]> spare = new ArrayList();
            int[] first = heap.peek();
            int start = first[0];

            for (int i = 0; i < groupSize; i++) {
                if (heap.isEmpty()) return false;

                int[] polled = heap.remove();

                int count = polled[1], value = polled[0];
                if(value != start + i) {
                    return false;
                }

                count--;
                if(count > 0) {
                    spare.add(new int[]{polled[0], count});
                }

            }

            heap.addAll(spare);
        }

        return true;
    }
}