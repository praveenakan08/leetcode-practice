// TC - O(m x n), SC - O(m x n)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int dirs[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> q = new LinkedList();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }


        while(!q.isEmpty()) {
            int polled[] = q.poll();
            int x = polled[0], y = polled[1];

            for(int[] dir: dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[0].length && mat[newX][newY] == Integer.MAX_VALUE) {
                    mat[newX][newY] = mat[x][y] + 1;
                    q.add(new int[]{newX, newY});   // add 1s to the q so that adj 1s can be updated to parent 1 + dist between new 1
                }
            }
        }
        
        return mat;
    }
}