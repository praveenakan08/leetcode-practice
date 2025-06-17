class Solution {

    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'X') {
                    count++;
                    dfs(i, j, board);
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, char[][] board) {
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] == '.') {
            return;
        }

        board[i][j] = '.';
    
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
}