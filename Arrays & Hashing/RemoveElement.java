// TC: O(n)
class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = 0, k = 0;

        while(right < nums.length && left < nums.length) {
            // finding the val
            while(left < nums.length && nums[left] != val) {
                left++;
            }

            right = left + 1;
            while(right < nums.length && nums[right] == val) {
                right++;
            }

            if(right < nums.length) {
                // swap
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }

        return left; 
    }
}