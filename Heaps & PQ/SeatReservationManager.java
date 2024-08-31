// TC - O(n), SC - O(n)
class SeatManager {
    int n;
    PriorityQueue<Integer> q;

    public SeatManager(int n) {
        this.n = n;

        // storing ONLY unreserved seats
        q = new PriorityQueue<Integer>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
    }

    public int reserve() {
        return q.poll();
    }

    public void unreserve(int seatNumber) {
        q.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */