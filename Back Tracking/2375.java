// TC - O(9!)
class Solution {
    private String result;

    public String smallestNumber(String pattern) {
        backtrack(pattern, new StringBuilder(), new boolean[10]);

        return result;
    }

    private void backtrack(String pattern, StringBuilder current, boolean[] visited) {
        if(current.length() == pattern.length() + 1) {
            if (result == null || current.toString().compareTo(result) < 0) {
                result = current.toString();
            }

            return;
        }

        for(int i = 1; i <= 9; i++) {
            if(visited[i]) {
                continue;
            }
            
            if(current.length() > 0) {
                int last = current.charAt(current.length() - 1) - '0';

                if(pattern.charAt(current.length() - 1) == 'I' && last >= i ||
                   pattern.charAt(current.length() - 1) == 'D' && last <= i) {
                    continue;
                } 
            }

            current.append(i);
            visited[i] = true;

            backtrack(pattern, current, visited);

            current.deleteCharAt(current.length() - 1);
            visited[i] = false;
        }
    }
}