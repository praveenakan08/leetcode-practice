// https://www.geeksforgeeks.org/dsa/sort-a-stack-using-recursion/
class Solution {
    // ex: stack -> [41, 3, 15, 6]

    private void sort(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int x = stack.pop();
            sort(stack);
            sortedStack(stack, x);
        }
    }   

    private void sortedStack(Stack<Integer> stack, int x) {
        if(stack.isEmpty() || x > stack.peek()) {
            stack.push(x);
            return;
        }

        int popped = stack.pop();
        sortedStack(stack, x);
        stack.push(popped);
    }   

    main() {
        sort(stack);
    }  
}