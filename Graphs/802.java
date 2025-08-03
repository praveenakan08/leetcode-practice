class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList();
        int[] safe = new int[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(dfs(i, graph, safe)) {
                result.add(i);
            }
        }

        Collections.sort(result);
        return result;
    }
     
    private boolean dfs(int key, int[][] graph, int[] safe) {
        if(safe[key] == -1) {
            return false;
        }

        safe[key] = -1;
        for(int dep: graph[key]) {
            if(safe[dep] != 1 && !dfs(dep, graph, safe)) {
                return false;
            }
        }

        safe[key] = 1;
        return true;
    }
}
