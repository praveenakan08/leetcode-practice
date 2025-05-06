class Solution {
    // https://www.geeksforgeeks.org/problems/geeks-training/0
    // TC - O(n*4) * 3
    // SC - O(n) 
    public int maximumPoints(int arr[][]) {
        int[][] dp = new int[arr.length][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return rec(arr.length - 1, 3, arr, dp);
    }
    
    private int rec(int currentRow, int lastIndex, int[][] arr, int[][] dp) {
        if(currentRow == 0) {
            int max = 0;
            for(int i = 0; i < arr[0].length; i++) {
                if(i != lastIndex) {
                    max = Math.max(max, arr[currentRow][i]);
                }
            }
            
            return max;
        }        
        
        if(dp[currentRow][lastIndex] != -1) {
            return dp[currentRow][lastIndex];
        }
        
        int max = 0;
        for(int i = 0; i < arr[0].length; i++) {
            if(i != lastIndex) {
                int points = arr[currentRow][i] + rec(currentRow - 1, i, arr, dp);
                max = Math.max(points, max);
            }
        }
        dp[currentRow][lastIndex] = max;
        
        return max;
    }


    // tabulation
    class Solution {
    public int maximumPoints(int[][] arr) {
        int n = arr.length;

        int[][] dp = new int[n][4];

        for (int last = 0; last < 4; last++) {
            int max = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    max = Math.max(max, arr[0][task]);
                }
            }
            dp[0][last] = max;
        }

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = arr[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], point);
                    }
                }
            }
        }

        return dp[n - 1][3];
    }
}
}