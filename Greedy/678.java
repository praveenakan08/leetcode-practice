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

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack();
        Stack<Integer> starStack = new Stack();

        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                openStack.push(i);
            } else if(s.charAt(i) == '*') {
                starStack.push(i);
            } else {
                if(!openStack.isEmpty()) {
                    openStack.pop();
                } else if(!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        while(!starStack.isEmpty() && !openStack.isEmpty()) {
            if(openStack.peek() > starStack.peek()) {
                return false;
            } 

            openStack.pop();
            starStack.pop();
        }
        
        return true;
    }
}