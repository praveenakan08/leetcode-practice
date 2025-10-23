// TC - O(n), SC - O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack();
        int[] result = new int[nums.length];

        Arrays.fill(result, -1);

        // [1, 2, 1, 1, 2, 1]
        // stack - [1, 2]
        // result - [2, -1, 2]
        for(int i = 0; i < 2 * nums.length; i++) {
            int index = i % nums.length;

            while(!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                int topIndex = stack.pop();
                result[topIndex] = nums[index];
            }

            stack.push(index);
        }

        return result;
    }
}