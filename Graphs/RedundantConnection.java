// TC - O(V + E), SC - O(V) 
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // union find algorithm
        int[] parent = new int[edges.length + 1];

        // parent of each node is itself
        for(int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges) {
            if(find(edge[0], parent) == find(edge[1], parent)) { // if both nodes have same parent then cycle
                return edge;
            } else {
                union(edge[0], edge[1], parent);
            }
        }

        return new int[]{};
    }

    // parent - [3, 1, 1]
    // find parent of 2 -- 3
    private int find(int n, int[] parent) {
        if(n == parent[n]) {
            return n;
        }

        return find(parent[n], parent);
    }

    // 1 -> 2
    // 3    -- if we want to union 3 and 2 
    // have to make 1 as 3's parent
    private void union(int u, int v, int[] parent) {
        parent[find(v, parent)] = find(u, parent); // parent[3] = 1
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;

        int[] parent = new int[n + 1];
        for(int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges) {
            if(find(edge[0], parent) == find(edge[1], parent)) {
                return new int[]{edge[0], edge[1]};
            } else {
                union(edge[0], edge[1], parent);
            }
        }

        return new int[0];
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