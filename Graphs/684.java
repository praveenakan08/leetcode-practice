class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int parent[] = new int[edges.length + 1];

        for(int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < edges.length; i++) {
            if(find(edges[i][0], parent) == find(edges[i][1], parent)) {
                return new int[]{edges[i][0], edges[i][1]};
            } else {
                union(edges[i][0], edges[i][1], parent);
            }
        }

        return new int[]{};
    }

    private int find(int x, int[] parent) {
        if(x == parent[x]) {
            return x;
        }

        return find(parent[x], parent);
    }

    private void union(int x, int y, int[] parent) {
        parent[find(y, parent)] = find(x, parent);
    }
}
