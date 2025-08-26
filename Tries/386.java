// TC - O(n), SC - O(n x max(digits in n))
class TrieNode {
    Map<Character, TrieNode> children = new TreeMap(); // add the children in ascending order 
    String number;
    boolean isEnd = false;
}

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList();

        TrieNode root = new TrieNode();
        for(int i = 1; i <= n; i++) {
            insert(root, String.valueOf(i));
        } 

        dfs(root, result);
        return result;
    }

    private void insert(TrieNode root, String num) {
        TrieNode node = root;
        for(char ch: num.toCharArray()) {
            node = node.children.computeIfAbsent(ch, n -> new TrieNode());
        }
         
        node.number = num;
        node.isEnd = true;
    }

    private void dfs(TrieNode root, List<Integer> result) {
        if(root.isEnd) {
            result.add(Integer.parseInt(root.number));
        }

        for(TrieNode child: root.children.values()) {
            dfs(child, result);
        }
    }
}

// DFS only
// TC - O(n), SC - O(1) excluding stack trace
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList();

        for(int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }

        return result;
    }

    private void dfs(int current, int n, List<Integer> result) {
        if(current > n) {
            return;
        }

        result.add(current);
        for(int i = 0; i <= 9; i++) {
            int next = current * 10 + i;
            if(next > n) {
                break;
            }

            dfs(next, n, result);
        }
    }
}