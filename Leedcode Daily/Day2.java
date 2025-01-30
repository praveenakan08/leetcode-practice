// 2493
class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList());
        }

        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int total = 0;
        int groups[] = new int[n + 1];
        Arrays.fill(groups, -1);

        for(int i = 1; i <= n; i++) {
            if(groups[i] == -1) {
                List<Integer> component = new ArrayList();
                if(!isBipartite(i, adj, component, groups)) { // adds all the nodes belonging to current node
                    return -1;
                }
                
                total += maxDepthBFS(adj, component);
            }   
        }

        // check for odd length cycle
        return total;
    }

    private boolean isBipartite(int current, List<List<Integer>> adj, List<Integer> component, int[] groups) {
        Queue<Integer> q = new LinkedList();
        q.add(current);
        component.add(current);
        groups[current] = 0;

        while(!q.isEmpty()) {
            int polled = q.poll();

            for(int dep: adj.get(polled)) {
                if(groups[dep] == -1) {
                    groups[dep] = 1 - groups[polled];
                    component.add(dep);
                    q.add(dep);

                } else if(groups[dep] == groups[polled]) {
                    return false;
                }
            }
        }

        return true;
    }

    private int maxDepthBFS(List<List<Integer>> adj, List<Integer> component) {
        int max = Integer.MIN_VALUE;
        for(int i: component) {
            boolean visited[] = new boolean[adj.size() + 1];
            max = Math.max(bfs(i, adj, visited), max);
        }

        return max;
    }

    private int bfs(int current, List<List<Integer>> adj, boolean[] visited) {
        Queue<Integer> q = new LinkedList();
        q.add(current);
        Map<Integer, Integer> depth = new HashMap();
        depth.put(current, 1);

        int maxDepth = 1;
        while(!q.isEmpty()) {
            int polled = q.poll();

            for(int dep: adj.get(polled)) {
                if(!depth.containsKey(dep)) {
                    depth.put(dep, depth.get(polled) + 1);
                    maxDepth = Math.max(maxDepth, depth.get(dep));
                    q.add(dep);
                }
            }
        }

        return maxDepth;
    }
}