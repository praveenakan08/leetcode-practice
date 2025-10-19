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