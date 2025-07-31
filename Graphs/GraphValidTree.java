class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) {
            return false;
        }

        int[] parent = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }


        // parent[] = {0 0 0 0 1}
                   //  0 1 2 3 4

        // 0 -> 1 -> 4
        //   -> 2
        //   -> 3 
        for(int[] edge: edges) {
            if(find(edge[0], parent) == find(edge[1], parent)) {
                return false;
            } else {
                union(edge[0], edge[1], parent);
            }
        }

        return true;
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
