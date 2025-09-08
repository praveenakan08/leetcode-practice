// TC - O(nxn), SC - O(1)
class Solution {
    public int[] sortArray(int[] nums) {
        // insertion sort
        for(int i = 1; i < nums.length; i++) {
            int key = nums[i], j = i - 1;

            while(j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key;
        }

        return nums;
    }
}

private int[] sort(int[] nums) {
    
    // insert the unsorted element at the correct place

    for(int i = 1; i < nums.length; i++) {
        int key = nums[i], j = i - 1;

        while(j >= 0 && nums[j] > key) {
            nums[j + 1] = nums[j];
            j--;
        }


        // placing the unsorted element at the correct position
        nums[j + 1] = key;
    }

    return nums;
}