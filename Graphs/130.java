class Solution {
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        
        // marking borders and invalid Os which are surrounded by border Os as "*"
        for(int i = 0; i < cols; i++) {
            if(board[0][i] == 'O') {
                dfs(0, i, board);
            }
            if(board[rows - 1][i] == 'O') {
                dfs(rows - 1, i, board);
            }
        }

        for(int i = 0; i < rows; i++) {
            if(board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if(board[i][cols - 1] == 'O') {
                dfs(i, cols - 1, board);
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if(board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }

    public void dfs(int i, int j, char[][] board) {
        // not out of bounds
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length ||
           board[i][j] != 'O') {
            return;
        }

        board[i][j] = '*';
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
}