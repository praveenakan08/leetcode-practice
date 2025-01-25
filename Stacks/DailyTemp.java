// TC - O(n), SC - O(n)
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> stack = new Stack();
        int[] result = new int[temp.length];

        for(int i = 0; i < temp.length; i++) {
            while(!stack.isEmpty() && stack.peek()[1] < temp[i]) {
                int[] popped = stack.pop();
                result[popped[0]] = i - popped[0];
            }

            stack.push(new int[]{i, temp[i]});
        }

        return result;
    }
}