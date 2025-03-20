// TC - O(E + Q), SC - O(1)
class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parent = new int[n];
        int[] minPathCost = new int[n];
        Arrays.fill(minPathCost, -1);

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges) {
            int weight = edge[2], srcRoot = find(edge[0], parent), destRoot = find(edge[1], parent);
            minPathCost[destRoot] &= weight;

            if(srcRoot != destRoot) {
                minPathCost[destRoot] &= minPathCost[srcRoot];
                parent[srcRoot] = destRoot;
            }
        }

        int result[] = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            int start = query[i][0], end = query[i][1];

            if(start == end) {
                result[i] = 0;
            } else if(find(start, parent) != find(end, parent)) {
                result[i] = -1;
            } else {
                result[i] = minPathCost[find(start, parent)];
            }
        }

        return result;
    }

    private int find(int x, int[] parent) {
        if(x != parent[x]) {
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }
}