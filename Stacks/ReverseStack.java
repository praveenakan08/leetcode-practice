class Solution {

    private void insertAtBottom(Stack<Integer> stack, int x) {
        if(stack.isEmpty()) {
            stack.push(x);
        } else {
            int popped = stack.pop();
            insertAtBottom(stack, x);
            stack.push(popped);
        }
    }

    private void reverse(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int x = stack.pop();
            reverse(stack);
            insertAtBottom(stack, x);
        }
    }   

    main() {
        reverse(stack);
    }
}