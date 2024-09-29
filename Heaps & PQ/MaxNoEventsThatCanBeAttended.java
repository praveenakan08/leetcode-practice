// TC - O(nlogn), SC - O(n)
class Solution {
    public int maxEvents(int[][] events) {
        // ex: [[1, 2], [1, 2], [1, 5], [1, 5], [3, 3]]
        // sorting events based on start date
        Arrays.sort(events, (e1, e2) -> e1[0] - e2[0]);

        // for getting the lowest end date, store in PQ
        Queue<Integer> q = new PriorityQueue();
        int count = 0, currentDay = 0, i = 0;

        while (i < events.length || !q.isEmpty()) {
            if (q.isEmpty()) {
                currentDay = events[i][0];
            }

            // add all the end days of the current day start date event to q
            // that means we have *end date* much time to attend the event
            while (i < events.length && events[i][0] <= currentDay) {
                q.add(events[i][1]);
                i++;
            }

            // attended the current event, remove from q
            q.poll();
            currentDay++;
            count++;

            // remove all the events which have past end date
            // current day has passed, we are unable to attend that event
            while (!q.isEmpty() && q.peek() < currentDay) {
                q.poll();
            }
        }

        return count;
    }
}