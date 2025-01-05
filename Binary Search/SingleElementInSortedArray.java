public // TC - O(logn), SC - O(1)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            if(left < nums.length - 1 && nums[left] == nums[left + 1]) {
                left = left + 2;
            } else {
                return nums[left];
            }

            if(right > 0 && nums[right] == nums[right - 1]) {
                right = right - 2;
            } else {
                return nums[right];
            }
        }

        return -1;
    }
}{

}
