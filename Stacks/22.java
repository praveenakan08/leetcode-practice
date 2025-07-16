class Solution {

    private List<String> result;
    private Deque<Character> stack;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList();
        stack = new ArrayDeque();

        backtrack(0, 0, n);
        return result;
    }

    private void backtrack(int open, int close, int n) {
        if(open == close && open == n) {
            Iterator<Character> i = stack.iterator();
            StringBuilder r = new StringBuilder();

            while(i.hasNext()) {
                r.append(i.next());
            }

            r.reverse();
            result.add(new String(r));
        }

        if(open < n) {
            stack.push('(');
            backtrack(open + 1, close, n);
            stack.pop();
        }

        if(close < open) {
            stack.push(')');
            backtrack(open, close + 1, n);
            stack.pop();
        }
    }
}