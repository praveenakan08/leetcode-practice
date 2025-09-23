class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int open = 1;

        char[] c = s.toCharArray();
        for(int i = 1; i < s.length(); i++) {
            if(c[i] == '(') {
                open++;

                if(open > 1) {
                    result.append('(');
                }
            } else {
                if(open > 1) {
                    result.append(')');
                }

                open--;
            }
        }

        return result.toString();
    }
}