// TC - O(n), SC - O(n)
class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Map<Integer, Integer> bobTime = new HashMap<>();
        findBobPath(bobTime, bob, adj, 0, 0, new boolean[n]);

        Queue<int[]> q = new LinkedList<>();
        int maxProfit = Integer.MIN_VALUE;
        boolean[] visited = new boolean[n];
        q.add(new int[]{0, 0, 0}); // {node, time, profit}

        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int current = polled[0], time = polled[1], profit = polled[2];

            visited[current] = true;
            if (bobTime.containsKey(current)) {
                if (time < bobTime.get(current)) {
                    profit += amount[current]; 
                } else if (time == bobTime.get(current)) {
                    profit += amount[current] / 2;
                }
            } else {
                profit += amount[current];
            }

            boolean isLeaf = true;
            for (int dep : adj.get(current)) {
                if (!visited[dep]) {
                    isLeaf = false;
                    q.add(new int[]{dep, time + 1, profit});
                }
            }

            if (isLeaf) {
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    // using backtrack to find bob path to 0
    private boolean findBobPath(Map<Integer, Integer> bobTime, int current, List<List<Integer>> adj, int currentTime, int target, boolean[] visited) {
        visited[current] = true;
        bobTime.put(current, currentTime);

        if (current == target) {
            return true;
        }
        
        for (int dep : adj.get(current)) {
            if (!visited[dep] && findBobPath(bobTime, dep, adj, currentTime + 1, target, visited)) {
                return true;
            }
        }

        bobTime.put(current, Integer.MAX_VALUE); // reset which are not in bob path
        return false;
    }
}
