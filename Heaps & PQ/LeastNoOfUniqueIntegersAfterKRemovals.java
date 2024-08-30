// TC - O(n), SC - O(n)
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // remove the numbers in increasing order of counts
        // 1 -> 2
        // 2 -> 1
        // 3 -> 3
        // 4 -> 1
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<int[]> q = new PriorityQueue(new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[1] - b[1];
            }
        });

        for (int key : map.keySet()) {
            q.add(new int[] { key, map.get(key) });
        }

        // remove 2, 4, 1 - unique - 2 (1, 3) left
        while (!q.isEmpty() && k > 0) {
            int[] first = q.peek();

            if (first[1] > k) {
                break;
            } else {
                q.poll();
                k -= first[1];
            }
        }

        return q.size();
    }
}