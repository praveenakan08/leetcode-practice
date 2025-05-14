class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // since the base case for this can be determined by the bottom row
        // because, from top row we can decide on 2 paths but from bottom we can for sure
        // say that we are considering current element in the min path
        return rec(0, 0, triangle);
    }

    private int rec(int i, int j, List<List<Integer>> triangle) {
        if(i == triangle.size() - 1) {
            return triangle.get(i).get(j);  // base case
        }

        int down = triangle.get(i).get(j) + rec(i + 1, j, triangle);
        int diagonal = triangle.get(i).get(j) + rec(i + 1, j + 1, triangle);

        return Math.min(down, diagonal);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        // since the base case for this can be determined by the bottom row
        // because, from top row we can decide on 2 paths but from bottom we can for sure
        // say that we are considering current element in the min path
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return rec(0, 0, triangle, dp);
    }

    private int rec(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        if(i == triangle.size() - 1) {
            return triangle.get(i).get(j);  // base case
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int down = triangle.get(i).get(j) + rec(i + 1, j, triangle, dp);
        int diagonal = triangle.get(i).get(j) + rec(i + 1, j + 1, triangle, dp);

        return dp[i][j] = Math.min(down, diagonal);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        // since the base case for this can be determined by the bottom row
        // because, from top row we can decide on 2 paths but from bottom we can for sure
        // say that we are considering current element in the min path
        int m = triangle.size();
        int[][] dp = new int[m][m];
        
        for(int i = 0; i < triangle.get(m - 1).size(); i++) {
            dp[m - 1][i] = triangle.get(m - 1).get(i);  // base case last row
        }

        // starting from second last row
        for(int i = m - 2; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];

                dp[i][j] = Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    }
}