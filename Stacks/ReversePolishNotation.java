// TC - O(n), SC - O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque();

        for(int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                if(!stack.isEmpty()) {
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    
                    if(token.equals("+")) {
                        stack.push(num1 + num2);
                    }

                    if(token.equals("-")) {
                        stack.push(num2 - num1);
                    }

                    if(token.equals("*")) {
                        stack.push(num1 * num2);
                    }

                    if(token.equals("/")) {
                        stack.push(num2 / num1);
                    }
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        

        return stack.peek();
    }
}