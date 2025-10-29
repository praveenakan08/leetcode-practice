// TC - O(n), SC - O(n)
class Solution {
    public String removeKdigits(String num, int k) {
        // 1432219        
        Stack<Character> stack = new Stack();

        for(int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);

            while(!stack.isEmpty() && stack.peek() > digit && k > 0) {
                k--;
                stack.pop();
            }

            stack.push(digit);
        }

        while(k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }

        while (result.length() > 0 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        result.reverse();

        if (result.length() == 0) {
            return "0";
        }

        return result.toString();
    }
}
