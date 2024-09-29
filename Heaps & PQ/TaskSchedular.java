// TC: O(n), SC: O(k)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. we have to store the counts of each of the tasks.
        int freq[] = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 65]++;
        }

        // 2. we have to store the freq in max heap, pop the highest freq value
        // add it to a queue and also what time it's avail to be executed i.e.,
        // currentTime + interval - MaxHeap
        Queue<Integer> maxHeap = new PriorityQueue(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                maxHeap.add(freq[i]);
            }
        }

        // 3. process the tasks from the queue when the currentTime = availTime of that
        // task
        // add {freq, availTime}
        // ex: {A, A, A, B, B, B}
        Queue<int[]> q = new LinkedList();
        int currentTime = 0;

        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            currentTime++;

            if (!maxHeap.isEmpty()) {
                // add the max freq to q
                int mostFreq = maxHeap.poll();
                mostFreq--;

                if (mostFreq > 0) {
                    q.add(new int[] { mostFreq, n + currentTime });
                }
            }

            if (!q.isEmpty() && q.peek()[1] == currentTime) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return currentTime;
    }
}