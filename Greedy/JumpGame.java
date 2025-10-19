// TC - O(n), SC - O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}

// TC - O(n), SC - O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] + i >= goal) {
                goal = i;
            }
         }

        return goal == 0;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] + i >= goal) {
                goal = i;
            }
        }
        
        return goal == 0;
    }
}

// TC - O(n), SC - O(1)
class Solution {
    public boolean canJump(int[] nums) {
        // another approach
        // 1. find the max index you can reach
        // 2. if current is > max index that means it cannot be reached, return false

        int maxIndex = 0;

        // [3,2,1,0,4]
        // [0,1,2,3,4]

        // max = 3
        for(int i = 0; i < nums.length; i++) {
            if(i > maxIndex) {
                return false;
            }

            maxIndex = Math.max(maxIndex, nums[i] + i);
        }

        return true;
        
    }
}