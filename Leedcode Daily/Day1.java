// 684
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int parent[] = new int[edges.length + 1];

        // initial - all the vertices parent as their own self
        for(int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }

        // find the vertices with common parent to find the connection to remove 
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

    // make parent of y = parent of x
    private void union(int x, int y, int[] parent) {
        parent[find(y, parent)] = find(x, parent); 
    }
}
