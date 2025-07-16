// TC - O(n), SC - O(n)
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] answer = new int[temp.length];
        Stack<Integer> stack = new Stack();

        for(int i = 0; i < temp.length; i++) {
            while(!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);
        }
        
        return answer;
    }
}