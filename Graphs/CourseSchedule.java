// TC - O(V + E), SC - O(V + E)
class Solution {
    public boolean canFinish(int numCourses, int[][] preq) {
        Map<Integer, List<Integer>> adj = new HashMap();
        for(int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList());
        }

        // 1 -> 0, 0 -> 1
        for(int i = 0; i < preq.length; i++) {
            adj.get(preq[i][0]).add(preq[i][1]);
        }

        int visited[] = new int[numCourses];
        for(int key: adj.keySet()) {
            if(visited[key] == 0 && !dfs(key, adj, visited)) {
                return false;
            }
        }

        return true;
     }

    private boolean dfs(int current, Map<Integer, List<Integer>> adj, int[] visited) {
        if(visited[current] == 2) {
            return false;
        }

        if(visited[current] == 1 || adj.get(current).isEmpty()) {
            return true;
        }

        visited[current] = 2;
        for(int dep: adj.get(current)) {
            if(!dfs(dep, adj, visited)) {
                return false;
            }
        }

        visited[current] = 1;
        return true;
    }   
}