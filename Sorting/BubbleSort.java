// TC - O(nxn), SC - O(1)
class Solution {
    public int[] sortArray(int[] nums) {
        // bubble sort
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }
}

private int[] sort(int[] nums) {

    // swap the largest element found that moment, and place it at the END
    for(int i = 0; i < nums.length; i++) {
        for(int j = 0; j < nums.length - 1; j++) {
            if(nums[j] > nums[j + 1]) {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
        }
    }
}