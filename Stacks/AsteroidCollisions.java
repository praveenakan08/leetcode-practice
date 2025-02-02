class Solution {
    public int[] asteroidCollision(int[] nums) {
        Stack<Integer> stack = new Stack();
        int index = 0;

        while(index < nums.length) {
            if(stack.isEmpty()) {
                stack.push(nums[index]);
                index++;
            } else {
                if(stack.peek() > 0 && nums[index] < 0) {
                    if(Math.abs(stack.peek()) > Math.abs(nums[index])) {
                        index++;
                    } else if(Math.abs(stack.peek()) < Math.abs(nums[index])) {
                        stack.pop();
                    } else {
                        stack.pop();
                        index++;
                    }
                } else {
                    stack.push(nums[index]);
                    index++;
                }
            }
        }

        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}