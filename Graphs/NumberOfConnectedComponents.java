class Solution {
    public int countComponents(int n, int[][] edges) {
        int result = 0;
        List<List<Integer>> adj = new ArrayList();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for (int node = 0; node < n; node++) {
            if (!visited[node]) {
                dfs(adj, visited, node);
                result++;
            }
        }

        return result;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;

        for(int dep: adj.get(node)) {
            if(!visited[dep]) {
                dfs(adj, visited, dep);
            }
        }
    }
}
