// using monotonic stack 
// TC - O(n), SC - O(n)
class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1);

            if(i == pattern.length() || pattern.charAt(i) == 'I') {
                while(!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        } 
        
        return result.toString();
    }
}
