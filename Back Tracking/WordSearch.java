class Solution {
    
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(dfs(i, j, 0, board, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int k, char[][] board, String word, boolean[][] visited) {
        if(k == word.length()) {
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(k) != board[i][j]
        || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        boolean result = dfs(i + 1, j, k + 1, board, word, visited) || 
                 dfs(i - 1, j, k + 1, board, word, visited) || 
                 dfs(i, j + 1, k + 1, board, word, visited) || 
                 dfs(i, j - 1, k + 1, board, word, visited); 
        visited[i][j] = false;
        return result;
    }
}