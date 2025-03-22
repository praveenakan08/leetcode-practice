class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }

        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        } 

        boolean[] visited = new boolean[n];
        int count = 0;

        // 1 -> {0, 2}
        // 0 -> {1, 2, 3}
        // 2 -> {0, 1}
        // 3 -> {0}

        // 0 -> 1 -> 2 -> 3
        for(int i = 0; i < n; i++) {
            if(!visited[i] && components(i, adj, visited)) {
                count++;
            }
        }

        return count;
    }

    private boolean components(int current, List<List<Integer>> adj, boolean visited[]) {
        Queue<Integer> q = new LinkedList();
        List<Integer> comp = new ArrayList();
        q.add(current);
        comp.add(current);
        visited[current] = true;

        while(!q.isEmpty()) {
            int polled = q.poll();
            

            for(int dep: adj.get(polled)) {
                if(!visited[dep]) {
                    visited[dep] = true;
                    comp.add(dep);
                    q.add(dep);
                }
            }
        }

        for(int c: comp) {
            if(comp.size() - 1 != adj.get(c).size()) {
                return false;
            }
        }

        return true;
    }
}