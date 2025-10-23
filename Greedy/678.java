class Solution {
    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack();

        int count = 0;

        // ((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())
        // stack = ((((((((((
        // count = 3
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == '*') {
                count++;
            } else {
                if(stack.isEmpty() && count > 0) {  // current is ), stack is empty - no (
                    count--;
                } else if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if(!stack.isEmpty() && count < stack.size()) {
            return false;
        }
        
        return true;
    }
}